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
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@CrossOrigin
@RequestMapping("/img")
@Deprecated
public class UploadController {
    private RestTemplate restTemplate = new RestTemplate();
    private final String upload="https://www.imgurl.org/api/v2/upload";
    @ResponseBody
    @PostMapping("/upload")
    public FileUploadResponse Get(@RequestParam("file") MultipartFile file){
        FileUploadResponse response=new FileUploadResponse();
        String fileName = file.getOriginalFilename();

        // 拼接文件路径
        try{
            byte[] data = file.getBytes();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
            ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            };
            requestBody.add("file", resource);
            requestBody.add("uid", "44ca3154a42e21b36eb08d644acd730e");
            requestBody.add("token", "b2b0166862548c5c1a1168c769636647");

            // 构造请求体，并执行请求
            HttpEntity<byte[]> requestEntity = new HttpEntity<>(data, headers);

            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    "https://www.imgurl.org/api/v2/upload", // 上传地址
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

        }catch (IOException e){
            e.printStackTrace();
        }


        // 设置请求头，指定上传文件类型和文件名

        String filePath = fileName;

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
