package com.bessaleks.internetprovider.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class OperationsHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String operationType;
    private Long operationSum;

    @ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonBackReference
    private User user;
}
