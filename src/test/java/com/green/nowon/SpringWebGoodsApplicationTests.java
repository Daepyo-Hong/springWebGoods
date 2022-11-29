package com.green.nowon;

import com.green.nowon.domain.entity.Goods;
import com.green.nowon.domain.entity.GoodsImg;
import com.green.nowon.domain.entity.GoodsImgRepository;
import com.green.nowon.domain.entity.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringWebGoodsApplicationTests {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodsImgRepository goodsImgRepository;

    @Test
    void 상품등록테스트() {

        Goods entity =Goods.builder()
                .title("상품명1")
                .content("상품내용 테스트1")
                .price(1000).stock(100)
                .build();
        goodsRepository.save(entity);

        GoodsImg goodsImg = GoodsImg.builder()
                .url("/img/goods/").name("img_1.jpg").size(11111111)
                .goods(entity)
                .build();
        goodsImgRepository.save(goodsImg);

    }

    //이미지 추가
    @Test
    void 이미지추가(){
        GoodsImg goodsImg = GoodsImg.builder()
                .url("/img/goods/").name("img_3.jpg").size(222222)
                .goods(Goods.builder().gno(1).build())
                .build();
        goodsImgRepository.save(goodsImg);
    }
    @Test
    void 이미지삭제(){
        goodsImgRepository.deleteById(2L);
    }

    @Test
    void 이미지수정(){
        GoodsImg goodsImg = goodsImgRepository.findById(1L).get();
        goodsImg.update("img_1_update.jpg");
        goodsImgRepository.save(goodsImg);
    }

    @Test
    void 상품읽어오기(){
        goodsRepository.findAll().forEach(e->{
            System.out.print(e.getTitle()+" : ");
            System.out.print(e.getContent()+" : ");
            System.out.println(e.getPrice());
            List<GoodsImg> imgs = goodsImgRepository.findAllByGoodsGno(e.getGno());

            for(GoodsImg gi:imgs){
                System.out.print(">>>"+gi.getUrl()+" : ");
                System.out.print(gi.getName()+" : ");
                System.out.println(gi.getSize());
            }
        });


    }
}
