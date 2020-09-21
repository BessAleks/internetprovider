package com.bessaleks.internetprovider.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table (name="operations_history")
public class OperationsHistory extends BaseEntity{

    @Column(name="operation_history_operationType")
    private String operationType;

    @Column(name="operation_history_operationSum")
    private Long operationSum;

    @ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "users")
    private User user;
}
