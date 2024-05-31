package co.develhope.ultimoEsercizio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    private static final String UPLOAD_DIR = "./uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Please select a file to upload");
            }

            // Save the file to the uploads directory
            byte[] bytes = file.getBytes();
            String filePath = UPLOAD_DIR + file.getOriginalFilename();
            try (OutputStream outputStream = new FileOutputStream(filePath)) {
                outputStream.write(bytes);
            }

            return ResponseEntity.ok().body("File uploaded successfully: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload file");
        }
    }
}
