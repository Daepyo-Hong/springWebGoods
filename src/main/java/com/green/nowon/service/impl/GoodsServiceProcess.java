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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GoodsServiceProcess implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsImgRepository goodsImgRepository;

    @Override
    public void save(GoodsInsertDTO dto, MultipartFile img) {

        Goods result = goodsRepository.save(dto.toEntity());
        MyFileUtils.fileUpload(img);

        String url = "/images/goods/";
        String name = img.getOriginalFilename();
        long size = img.getSize();
        goodsImgRepository.save(GoodsImg.builder()
                        .url(url).name(name).size(size)
                        .goods(result)
                        .build());
    }
}
