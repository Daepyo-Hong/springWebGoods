package com.green.nowon.service.impl;

import com.green.nowon.domain.dto.GoodsInsertDTO;
import com.green.nowon.domain.entity.Goods;
import com.green.nowon.domain.entity.GoodsImg;
import com.green.nowon.domain.entity.GoodsImgRepository;
import com.green.nowon.domain.entity.GoodsRepository;
import com.green.nowon.service.GoodsService;
import com.green.nowon.utils.MyFileUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GoodsServiceProcess implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsImgRepository goodsImgRepository;

    @Value("${multipart.upload.path}")  //프로퍼티즈에있는 값 받아오는것
    private String uploadPath;

    @Override
    public void save(GoodsInsertDTO dto, MultipartFile img) {

        //Goods result = goodsRepository.save(dto.toEntity());

        goodsImgRepository.save(
                MyFileUtils.fileUpload(img, uploadPath)
                        .goods(goodsRepository.save( dto.toEntity() ))
        );
    }
}
