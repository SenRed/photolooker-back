package com.photolooker.back.infrastructure.primary;

import com.photolooker.back.domain.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PictureController {

    private final Logger logger = LoggerFactory.getLogger(PictureController.class);

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/hello")
    public void hello() {
        System.out.println("hello");
    }

    @PostMapping("/picture")
    public ResponseEntity<?> uploadPicture(
            @RequestParam("userId") String userId,
            @RequestParam("files") MultipartFile[] files) {
        logger.debug("upload received");
        try {
            // Check if the uploaded files array is empty
            if (files.length == 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No files uploaded.");
            }
            List<String> picturesURL = new ArrayList<>();
            for (MultipartFile file : files) {
                // Check if the uploaded file size exceeds 20 MB (20 * 1024 * 1024 bytes)
                if (file.getSize() > 20 * 1024 * 1024) {
                    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                            .body(Map.of("message", "One or more files exceed the allowed limit.").toString());
                }

                var pictureURL = pictureService.save(userId, file.getOriginalFilename(), file.getBytes());
                picturesURL.add(pictureURL);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(picturesURL);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that may occur during image processing
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the images.");
        }
    }

}