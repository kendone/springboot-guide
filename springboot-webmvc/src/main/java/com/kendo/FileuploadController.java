package com.kendo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author kendone
 */
@Controller
public class FileuploadController {

    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }

    @GetMapping("/uploadResult")
    public String uploadResult(){
        return "uploadResult";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "请选择文件");
            return "redirect:/uploadResult";
        }

        String name = file.getOriginalFilename();
        try {
            Files.write(new File(name).toPath(), file.getBytes());
            redirectAttributes.addFlashAttribute("message", "文件【" + file.getOriginalFilename() + "】上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadResult";
    }
}