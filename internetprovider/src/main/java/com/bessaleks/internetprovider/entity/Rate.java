package com.bessaleks.internetprovider.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="rates")
public class RateDto extends BaseEntityDto {

    @Column(name="rate_rateName")
    private String rateName;

    @Column(name="rate_speed")
    private Long speed;

    @Column(name="rate_price")
    private Double price;

    @OneToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    private ContractDto contractDto;

}
