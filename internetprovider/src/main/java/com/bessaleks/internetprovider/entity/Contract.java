package com.bessaleks.internetprovider.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="contracts")
public class Contract extends BaseEntity {

    @Column(name="contract_number")
    private String number;

    @Column(name="contract_startDate")
    private Date startDate;

    @OneToOne(mappedBy = "contract", fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rate_id")
    private Rate rate;

}
