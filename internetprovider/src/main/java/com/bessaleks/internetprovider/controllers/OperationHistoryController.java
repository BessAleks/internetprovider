package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.servises.OperationHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("operation_history")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class OperationHistoryController {

    private OperationHistoryService operationHistoryService;

    @PostMapping
    public OperationHistoryDto createOperationHistory(@RequestBody OperationHistoryDto operationHistoryDto) {
        return operationHistoryService.createOperationHistory(operationHistoryDto);
    }
    @GetMapping
    public List<OperationHistoryDto> getAll() {
        return operationHistoryService.getAll();
    }

    @GetMapping("id")
    public OperationHistoryDto getOperationHistory(@PathParam("id") Long id) {
        return operationHistoryService.getOperationHistory(id);
    }

    @PutMapping
    public OperationHistoryDto updateOperationHistory(@RequestBody OperationHistoryDto operationHistoryDto) {
        return operationHistoryService.updateOperationHistory(operationHistoryDto);
    }

    @DeleteMapping
    public void deleteOperationHistory(@PathParam("id") Long id) {
        operationHistoryService.deleteOperationHistory(id);
    }
}
