package com.bessaleks.internetprovider.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table (name="passports")
public class Passport extends BaseEntity{

    @OneToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "users")
    private User user;

    @Column(name="user_name")
    private String name;

    @Column(name="user_surname")
    private String surname;

    @Column(name="user_lastName")
    private String lastName;

    @Column(name="passport_passportNumber")
    private Long passportNumber;

    @Column(name="passport_passportIssuedBy")
    private String passportIssuedBy;

    @Column(name="passport_passportIssued")
    private Date passportIssued;

    @Column(name="passport_birthday")
    private Date birthday;

    @Column(name="passport_sex")
    private Sex sex;
}
