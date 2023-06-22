package com.example.backend.controller;

import com.example.backend.dto.FileUploadResponse;
import com.example.backend.dto.FileUrl;
import com.example.backend.dto.Response;
import com.example.backend.dto.Status;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Controller
@CrossOrigin
@RequestMapping("/img")

public class UploadController {
    @ResponseBody
    @PostMapping("/upload")
    public FileUploadResponse  Get(@RequestParam("file") MultipartFile file){
        FileUploadResponse response=new FileUploadResponse();
        String filePath = "src/main/resources/static/";

        try {
            // 获取文件名
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // 创建目标文件路径
            Path targetPath = Path.of(filePath, fileName);

            // 将文件复制到目标路径
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            // 构建文件资源对象
            Resource resource = new FileSystemResource(targetPath.toFile());
            response.setData(new FileUrl());
            response.getData().setFileUrl("http://127.0.0.1:3020/"+file.getOriginalFilename());
            response.setStatus(new Status());
            response.getStatus().setCode(200);
            response.getStatus().setMessage("上传成功");
            // 返回上传成功的消息和文件URL
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            // 返回上传失败的消息
            response.setStatus(new Status());
            response.getStatus().setMessage("上传失败");
            return response;
        }

    }

    @ResponseBody
    @GetMapping("/download/:{fileName}")
    public FileUploadResponse  Download(@PathVariable("fileName")String fileName){
        String filePath = "src/main/resources/static/";

        FileUploadResponse response=new FileUploadResponse();

            // 创建目标文件路径
            Path targetPath = Path.of(filePath, fileName);

            response.setData(new FileUrl());
            response.getData().setFileUrl("http://127.0.0.1:3020/"+fileName);
            response.setStatus(new Status());
            response.getStatus().setCode(200);
            response.getStatus().setMessage("上传成功");
            // 返回上传成功的消息和文件URL
            return response;
    }
}
