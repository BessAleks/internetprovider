package com.bessaleks.internetprovider.entity;

import com.bessaleks.internetprovider.enums.OperationType;
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
@Table (name="operations_histories")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "operation_history_id"))})
public class OperationsHistory extends BaseEntity {

    @Column(name="operation_history_operation_type")
    @Enumerated(value = EnumType.STRING)
    private OperationType operationType;

    @Column(name="operation_history_operation_sum")
    private Long operationSum;

    @Column(name = "operation_history_operation_date")
    private LocalDateTime operationDate;

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
