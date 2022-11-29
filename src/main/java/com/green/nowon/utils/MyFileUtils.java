package com.green.nowon.utils;


import com.green.nowon.domain.entity.GoodsImg;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Log4j2
public class MyFileUtils {


    //파일 업로드 처리 이후 DB에 저장할 GoodsImg 엔티티 객체를 리턴
    public static GoodsImg fileUpload(MultipartFile img, String uploadPath)  {
        ClassPathResource cpr = new ClassPathResource("static"+uploadPath);
        String fileName =null;
        try {
            File uploadFolder = cpr.getFile();
            fileName = img.getOriginalFilename();

            img.transferTo(new File(uploadFolder, fileName));
            log.info(">>>> 파일 업로드 테스트 : file upload done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return GoodsImg.builder()
                .url(uploadPath)
                .name(fileName)
                .size(img.getSize())
                .build();
    }
}
