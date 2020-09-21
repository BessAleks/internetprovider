package com.bessaleks.internetprovider.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table (name="contracts")
public class Contract extends BaseEntity{

    @Column(name="contract_number")
    private String number;

    @Column(name="contract_startDate")
    private Date startDate;

    @ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinTable(name = "address")
    private Address address;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinTable(name = "rates")
    private Rate rate;
}
