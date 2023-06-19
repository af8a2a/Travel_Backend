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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@CrossOrigin
@RequestMapping("/img")
public class UploadController {
    private final String upload="https://www.imgurl.org/api/v2/upload";
    @ResponseBody
    @PostMapping("/upload")
    public FileUploadResponse Get(@RequestParam("file") MultipartFile file){
        FileUploadResponse response=new FileUploadResponse();
        String fileName = file.getOriginalFilename();

        // 拼接文件路径
        String filePath = "D:\\backend\\src\\main\\resources\\static" + fileName;

        try {
            // 保存文件到本地
            File dest = new File(filePath);
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            // 处理文件保存失败的情况
        }
        Status status=new Status();
        status.setMessage("上传成功");
        status.setCode(200);
        FileUrl url=new FileUrl();

        url.setFileUrl("http://127.0.0.1:3020/"+fileName);
        System.out.println();
        response.setStatus(status);
        response.setData(url);
        return response;
    }

    @ResponseBody
    @GetMapping("/download/:{filename}")
    public String Download(@PathVariable("filename")String filename){
        return "http://127.0.0.1:3020/"+filename;
    }
}
