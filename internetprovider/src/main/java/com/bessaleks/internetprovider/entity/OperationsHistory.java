package com.bessaleks.internetprovider.dto;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="operations_history")
public class OperationsHistoryDto extends BaseEntityDto {

    @Column(name="operation_history_operationType")
    private String operationType;

    @Column(name="operation_history_operationSum")
    private Long operationSum;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private UserDto userDto;

}
