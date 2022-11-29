package com.green.nowon.domain.dto;


import com.green.nowon.domain.entity.Goods;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Setter
@ToString
public class GoodsInsertDTO {
    private String title;
    private int price;
    private int stock;
    private String content;

    public Goods toEntity() {
        return Goods.builder()
                .title(title)
                .content(content)
                .price(price).stock(stock)
                .build();
    }
}
