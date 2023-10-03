package com.photolooker.back.infrastructure.secondary.blobstorage;

import com.photolooker.back.domain.PictureLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

public class SirvBlobRepositoryTest {

    @Mock
    private SirvClient sirvClient;

    private SirvBlobRepository sirvBlobRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        sirvBlobRepository = new SirvBlobRepository(sirvClient);
    }


    @Test
    public void testSavePicture() throws IOException {
        // Given
        String userId = "testUser";
        when(sirvClient.getToken()).thenReturn("YOUR_BEARER_TOKEN_HERE");
        // doNothing().when(sirvClient).uploadFile(any(),any(),any());
        File tempFile = createTempFile();

        // When
        String pictureLink = sirvBlobRepository.savePicture(userId, tempFile.getName(),null );

        // Then
        assertThat(pictureLink).isEqualTo(PictureLink.create(userId,tempFile.getName()).getPath());
        tempFile.delete();
    }

    private File createTempFile() throws IOException {
        Path tempFilePath = Files.createTempFile("test", ".jpg");
        InputStream is = getClass().getClassLoader().getResourceAsStream("test.jpg");
        Files.copy(is, tempFilePath, StandardCopyOption.REPLACE_EXISTING);
        return tempFilePath.toFile();
    }
}