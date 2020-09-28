package com.bessaleks.internetprovider.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="contracts")
public class ContractDto extends BaseEntityDto {

    @Column(name="contract_number")
    private String number;

    @Column(name="contract_startDate")
    private Date startDate;

    @OneToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    private AddressDto addressDto;

    @NotBlank
    @OneToOne
    @MapsId
    @JoinColumn(name="rateId")
    private RateDto rateDto;

}
