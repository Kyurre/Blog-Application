package com.application.blog.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FileResponse {

    private String fileName;
    private String message;
}
