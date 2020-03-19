package com.kendo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author kendone
 */
@Controller
public class FileuploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            System.out.println("file name： " + name);
            try {
                assert name != null;
                Files.write(new File(name).toPath(), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "index";
    }
}