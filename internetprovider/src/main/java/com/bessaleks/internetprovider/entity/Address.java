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
@Table (name="addresses")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "address_id"))})
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

    @Column(name="address_postcode")
    private Long postCode;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Contract contract;

}
