package com.photolooker.back.infrastructure.secondary.blobstorage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class SirvClient {

    public static final String UPLOAD_SIRV_URL = "https://api.sirv.com/v2";
    public static final String READ_SIRV_URL = "https://errosteg.sirv.com/";
    private final RestTemplate restTemplate;
    private final String clienId;
    private final String clientSecret;

    public SirvClient(RestTemplate restTemplate,
                      @Value("${sirv.clientId}") String clientId,
                      @Value("${sirv.clientSecret}") String clientSecret) {
        this.restTemplate = restTemplate;
        this.clienId = clientId;
        this.clientSecret = clientSecret;
    }


    public String getToken() {
        TokenRequest tokenRequest = new TokenRequest(this.clienId, this.clientSecret);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TokenRequest> request = new HttpEntity<>(tokenRequest, headers);

        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(UPLOAD_SIRV_URL + "/token", request, TokenResponse.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            System.err.println("Get Token failed: " + response.getStatusCode());
            throw new RuntimeException("Get Token failed " + response.getStatusCode());
        }
        return response.getBody().getToken();
    }

    public void uploadFile(String remoteFilePath, byte[] fileContent) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setBearerAuth(this.getToken());

        URI uri = UriComponentsBuilder
                .fromHttpUrl(UPLOAD_SIRV_URL + "/files/upload")
                .queryParam("filename", remoteFilePath)
                .build()
                .toUri();
        HttpEntity<Object> httpEntity = new HttpEntity<>(fileContent, requestHeaders);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("File uploaded successfully.");
        } else {
            System.err.println("File upload failed with status code: " + response.getStatusCode());
            throw new RuntimeException("Upload failed status code: " + response.getStatusCode());
        }
    }
}