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
@SequenceGenerator(name = "gen_seq_good", sequenceName = "seq_good",
        initialValue = 1,allocationSize = 1)
@Entity
public class Goods extends BaseEntity{

    @Id
    @GeneratedValue(generator = "gen_seq_good",strategy = GenerationType.SEQUENCE)
    private long gno;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "text")
    private String content;
    private int price;
    private int stock;
}
