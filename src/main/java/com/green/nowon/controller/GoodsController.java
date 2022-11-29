package com.green.nowon.controller;

import com.green.nowon.domain.dto.GoodsInsertDTO;
import com.green.nowon.service.GoodsService;
import com.green.nowon.service.impl.GoodsServiceProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService service;

    @GetMapping("/manytoone")
    public String goods(){
        return "/manytoone/reg";
    }
    @PostMapping("/manytoone")
    public String goods(GoodsInsertDTO dto, MultipartFile img){
       // System.out.println(dto);
        //System.out.println("파일이름:"+img.getOriginalFilename());

        service.save(dto, img);

        return "redirect:/manytoone";
    }

}
