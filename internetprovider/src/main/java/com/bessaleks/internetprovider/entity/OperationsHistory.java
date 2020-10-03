package com.bessaleks.internetprovider.entity;

import com.bessaleks.internetprovider.enums.OperationType;

import javax.persistence.*;

@Entity
@Table (name="operations_history")
public class OperationsHistory extends BaseEntity {

    @Column(name="operation_history_operationType")
    private OperationType operationType;

    @Column(name="operation_history_operationSum")
    private Long operationSum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
