package com.green.nowon.service;

import com.green.nowon.domain.dto.GoodsInsertDTO;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {

    void save(GoodsInsertDTO dto, MultipartFile img);
}
