package com.epam.rd.izh.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Component
@Data
public class PictureService {

    /*Теория https://attacomsian.com/blog/spring-boot-thymeleaf-file-upload#running--testing-the-application*/
    Path pathToSafePicture;

    public void pictureSaver(MultipartFile file, String path){

        pathToSafePicture = Paths.get("src/main/resources/static/" + path);

        try {
            Files.copy(file.getInputStream(), pathToSafePicture, StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
