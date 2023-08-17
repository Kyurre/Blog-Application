package com.application.blog.services.impl;

import com.application.blog.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        // File name
        String fname = file.getOriginalFilename();

        // Create random name string
        //TODO: Add a sanity check after the '.' to see if it is png or jpeg
        String randomID = UUID.randomUUID().toString();
        String fileName = randomID.concat(fname.substring(fname.lastIndexOf('.')));

        // Create path to file
        String fpath = path + File.separator + fileName;


        // Create images folder in project directory
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        // upload file/ copy file
        Files.copy(file.getInputStream(), Paths.get(fpath));

        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream is = new FileInputStream(fullPath);

        // db logic to return input stream
        return is;
    }
}
