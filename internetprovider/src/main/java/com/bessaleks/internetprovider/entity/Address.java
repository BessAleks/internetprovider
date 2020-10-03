package com.bessaleks.internetprovider.entity;

import javax.persistence.*;

@Entity
@Table (name="addresses")
public class Address extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="address_country")
    private String country;

    @Column(name="address_city")
    private String city;

    @Column(name="address_street")
    private String street;

    @Column(name="address_house")
    private String house;

    @Column(name="address_flat")
    private String flat;

    @Column(name="address_postCode")
    private Long postCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contract_id")
    private Contract contract;

}
