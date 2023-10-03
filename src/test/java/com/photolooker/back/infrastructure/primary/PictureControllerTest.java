package com.photolooker.back.infrastructure.primary;

import com.photolooker.back.domain.PictureService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PictureControllerTest {

    @Test
    public void testUploadPictureSuccess() throws Exception {

        PictureService pictureService = Mockito.mock(PictureService.class);
        PictureController pictureController = new PictureController(pictureService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(pictureController).build();


        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test-image.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                "Test image content".getBytes()
        );


        mockMvc.perform(
                        multipart("/picture")
                                .file(file)
                                .param("userId", "id")
                )
                .andExpect(status().isOk());
    }

    @Test
    public void testUploadPictureExceedsSizeLimit() throws Exception {

        PictureService pictureService = Mockito.mock(PictureService.class);
        PictureController pictureController = new PictureController(pictureService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(pictureController).build();

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "large-image.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                new byte[21 * 1024 * 1024] // Créez un tableau d'octets de 21 Mo
        );

        mockMvc.perform(
                        multipart("/picture")
                                .file(file)
                                .param("userId", "id")
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().string("The image size exceeds the allowed limit."));
    }
}