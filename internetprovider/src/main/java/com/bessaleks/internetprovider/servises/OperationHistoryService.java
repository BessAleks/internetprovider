package com.bessaleks.internetprovider.servises;

import com.bessaleks.internetprovider.dto.OperationHistoryDto;

import java.util.List;

public interface OperationHistoryService {
    OperationHistoryDto createOperationHistory(OperationHistoryDto operationHistoryDto);
    OperationHistoryDto updateOperationHistory(OperationHistoryDto operationHistoryDto);
    OperationHistoryDto getOperationHistory(Long id);
    List<OperationHistoryDto> getAll();
    void deleteOperationHistory(Long id);
}
