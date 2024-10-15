package com.example.demo.controllers;

import com.example.demo.fileId.FileIdentification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

@CrossOrigin
@RestController
public class FileTypeController {

    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public void Status(){
        try {
            Files.walkFileTree(Paths.get("/Users/developer/Downloads/demo/TestFiles"), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileIdentification.getFileTypeForFile(file);
                    return super.visitFile(file, attrs);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
