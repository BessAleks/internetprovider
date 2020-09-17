package com.bessaleks.internetprovider.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    private User user;

    private Long passportNumber;
    private String passportIssued;
    private Date passportDate,birthday;
    private String sex;
}
