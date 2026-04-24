package com.zz.controller;

import com.zz.entities.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/api/file")
public class FileController {
    @Value("${file.upload.path}")
    private String fileUploadPath;

    @RequestMapping("/upload")
    public ResultData upload(MultipartFile file) {
        long time = new Date().getTime();
        String filename = time + file.getOriginalFilename();
        try {
            // 确保目录存在，如果不存在则创建
            java.nio.file.Path uploadPath = java.nio.file.Paths.get(fileUploadPath);
            if (!java.nio.file.Files.exists(uploadPath)) {
                java.nio.file.Files.createDirectories(uploadPath);
            }
            // 构建目标文件路径
            String targetFilePath = fileUploadPath + filename;

            // 将上传的文件保存到目标路径
            try (InputStream inputStream = file.getInputStream();
                 OutputStream outputStream = new FileOutputStream(targetFilePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            // 文件上传成功
            System.out.println("文件上传成功: " + targetFilePath);
            return ResultData.ok(filename);
        } catch (IOException e) {
            // 文件上传失败
            System.out.println("文件上传失败: " + e.getMessage());
        }
        return ResultData.err("图片上传失败");
    }

    @RequestMapping("/{filename}")
    public void show(HttpServletResponse response, @PathVariable String filename){
        File file = new File(fileUploadPath + filename);

        // 设置响应内容类型
        String contentType = "image/jpeg";
        response.setContentType(contentType);
        response.setContentLength((int) file.length());

        try {
            // 将文件内容写入响应输出流
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            // 关闭流
            outputStream.flush();
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
