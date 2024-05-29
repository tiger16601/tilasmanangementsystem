package com.rolling.controller;

import com.rolling.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("上传文件:{},{},{}", username, age, image);
        String originalFilename = image.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("保存新文件名:{}", newFileName);
        image.transferTo(new File("C:\\Users\\Rolling\\Desktop\\New folder" + newFileName));
        return Result.success();
    }
}
