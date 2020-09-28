package com.bessaleks.internetprovider.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="addresses")
public class AddressDto extends BaseEntityDto {

    @OneToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    private PassportDto passportDto;

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

    @NotBlank
    @OneToOne
    @MapsId
    @JoinColumn(name="contractId")
    private ContractDto contractDto;

}
