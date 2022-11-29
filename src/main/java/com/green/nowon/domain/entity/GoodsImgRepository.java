package com.green.nowon.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsImgRepository extends JpaRepository<GoodsImg, Long> {

    List<GoodsImg> findAllByGoodsGno(long gno);
}
