package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OperationHistoryToOperationHistoryDtoConverter implements Converter<OperationsHistory, OperationHistoryDto> {
    private final CustomConversionService customConversionService;

    @Autowired
    public OperationHistoryToOperationHistoryDtoConverter(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }

    @Override
    public OperationHistoryDto convert(OperationsHistory operationsHistory) {
        OperationHistoryDto operationHistoryDto = new OperationHistoryDto();
        operationHistoryDto.setId(operationsHistory.getId());
        operationHistoryDto.setOperationType(operationsHistory.getOperationType());
        operationHistoryDto.setOperationSum(operationsHistory.getOperationSum());
        operationHistoryDto.setOperationDate(operationsHistory.getOperationDate());
        return operationHistoryDto;
    }
}
