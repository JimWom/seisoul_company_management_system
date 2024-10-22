package com.seisoul.compamyManagementSystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    // 上传文件
    @PostMapping("/file")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String filePath = "/path/to/your/external/directory/" + file.getOriginalFilename();
        File dest = new File(filePath);
        file.transferTo(dest);  // 将上传的文件保存到指定目录
        return "File uploaded successfully: " + filePath;
    }
}
