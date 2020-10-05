package com.bessaleks.internetprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="rates")
public class Rate extends BaseEntity {

    @Column(name="rate_rateName")
    private String rateName;

    @Column(name="rate_speed")
    private Long speed;

    @Column(name="rate_price")
    private Double price;

    @OneToOne(mappedBy = "rate", fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    private Contract contract;

}
