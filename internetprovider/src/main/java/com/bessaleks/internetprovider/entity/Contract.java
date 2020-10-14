package com.bessaleks.internetprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="contracts")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "contract_id"))})
public class Contract extends BaseEntity {

    @Column(name="contract_number")
    private String number;

    @Column(name="contract_start_date")
    private LocalDateTime startDate;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;

}
