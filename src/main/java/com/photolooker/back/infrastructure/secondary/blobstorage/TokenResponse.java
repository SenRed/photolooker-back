package com.photolooker.back.infrastructure.secondary.blobstorage;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token",
        "expiresIn",
        "scope"
})
public class TokenResponse {

    @JsonProperty("token")
    private String token;
    @JsonProperty("expiresIn")
    private Integer expiresIn;
    @JsonProperty("scope")
    private List<String> scope = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties;

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("expiresIn")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    @JsonProperty("expiresIn")
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @JsonProperty("scope")
    public List<String> getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(List<String> scope) {
        this.scope = scope;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}