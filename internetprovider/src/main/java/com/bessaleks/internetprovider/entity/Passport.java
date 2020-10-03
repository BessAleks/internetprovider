package com.bessaleks.internetprovider.entity;

import com.bessaleks.internetprovider.enums.Sex;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="passports")
public class Passport extends BaseEntity {

    @OneToOne(mappedBy = "passport", fetch= FetchType.LAZY, cascade=CascadeType.ALL)
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
