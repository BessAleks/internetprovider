package com.bessaleks.internetprovider.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@Table (name="address")
public class Address extends BaseEntity{

    @ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "users")
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

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Contract> contracts;

}
