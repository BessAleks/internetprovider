package com.bessaleks.internetprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="rates")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "rate_id"))})
public class Rate extends BaseEntity {

    @Column(name="rate_rate_name")
    private String rateName;

    @Column(name="rate_speed")
    private Long speed;

    @Column(name="rate_price")
    private Double price;

    @OneToMany(mappedBy = "rate", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<Contract> contracts = new HashSet<>();

}
