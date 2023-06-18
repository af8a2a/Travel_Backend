package com.example.backend.dto;

import lombok.Data;
@Data
public class FileUploadResponse {
    Status status;
    FileUrl data;
}
