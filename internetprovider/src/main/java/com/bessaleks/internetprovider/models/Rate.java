package com.bessaleks.internetprovider.models;

import javax.persistence.*;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String rateName;
    private Long speed;
    private Double price;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    private Contract contract;
}
