package com.green.nowon.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Getter
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "gen_seq_img", sequenceName = "seq_img",
        initialValue = 1,allocationSize = 1)
@Entity
public class GoodsImg extends BaseEntity{

    @Id
    @GeneratedValue(generator = "gen_seq_img",strategy = GenerationType.SEQUENCE)
    private long ino;
    @Column(nullable=false)
    private String url;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private long size;

    @JoinColumn(name = "gno")
    @ManyToOne// N:1관계에서 물리FK는 무조건 N쪽 테이블에 생성
    private Goods goods;

    public GoodsImg updateName(String name) {
        this.name=name;
        return this;
    }
}
