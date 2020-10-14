package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import com.bessaleks.internetprovider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OperationHistoryDtoToOperationHistoryConverter implements Converter<OperationHistoryDto, OperationsHistory> {

    @Override
    public OperationsHistory convert(OperationHistoryDto operationHistoryDto) {
        OperationsHistory operationsHistory = new OperationsHistory();
        operationsHistory.setOperationType(operationHistoryDto.getOperationType());
        operationsHistory.setOperationSum(operationHistoryDto.getOperationSum());
        operationsHistory.setOperationDate(operationHistoryDto.getOperationDate());
        return operationsHistory;
    }
}
