package com.bessaleks.internetprovider.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table (name="rates")
public class Rate extends BaseEntity{

    @Column(name="rate_rateName")
    private String rateName;

    @Column(name="rate_speed")
    private Long speed;

    @Column(name="rate_price")
    private Double price;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinTable(name = "contracts")
    private Contract contract;
}
