package com.bessaleks.internetprovider.dto;

import com.bessaleks.internetprovider.enums.OperationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationHistoryDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty(value = "operation_history_operation_type")
    private OperationType operationType;

    @JsonProperty(value = "operation_history_operation_sum")
    private Long operationSum;

    @JsonProperty(value = "operation_history_operation_date")
    private LocalDateTime operationDate;

    @JsonProperty(value = "operation_history_user")
    private UserDto userDto;
}
