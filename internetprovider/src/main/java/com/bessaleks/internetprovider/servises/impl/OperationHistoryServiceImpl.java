package com.bessaleks.internetprovider.servises.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.enums.OperationType;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.OperationsHistoryRepository;
import com.bessaleks.internetprovider.repository.UserRepository;
import com.bessaleks.internetprovider.servises.OperationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OperationHistoryServiceImpl implements OperationHistoryService {
    private final OperationsHistoryRepository operationsHistoryRepository;
    private final UserRepository userRepository;
    private final CustomConversionService customConversionService;

    @Autowired
    public OperationHistoryServiceImpl(OperationsHistoryRepository operationsHistoryRepository, UserRepository userRepository, CustomConversionService customConversionService) {
        this.operationsHistoryRepository = operationsHistoryRepository;
        this.userRepository = userRepository;
        this.customConversionService = customConversionService;
    }


    @Override
    public OperationHistoryDto createOperationHistory(OperationHistoryDto operationHistoryDto) {
        User user = userRepository.findById(operationHistoryDto.getUserDto().getId()).orElseThrow(() -> new NotFoundException("User is not found"));
        OperationsHistory operationsHistory = customConversionService.convert(operationHistoryDto,OperationsHistory.class);
        if(operationHistoryDto.getOperationType().equals(OperationType.ADD)) {
            user.setBalanse(user.getBalanse().add(operationHistoryDto.getOperationSum()));
        }
        else if (operationHistoryDto.getOperationType().equals(OperationType.DEBIT)){
            user.setBalanse(user.getBalanse().subtract(operationHistoryDto.getOperationSum()));
        }
        else {
            throw new ExceptionInInitializerError("Error operation!");

        }
        user.getOperationsHistories().add(operationsHistory);
        operationsHistory.setUser(user);
        customConversionService.convert(userRepository.save(user),UserDto.class);
        return customConversionService.convert(operationsHistoryRepository.save(operationsHistory), OperationHistoryDto.class);
    }

    @Override
    public OperationHistoryDto updateOperationHistory(OperationHistoryDto operationHistoryDto) {
        OperationsHistory operationsHistory = operationsHistoryRepository.findById(operationHistoryDto.getId()).orElseThrow(() -> new NotFoundException("Operation is not found"));
        operationsHistory.setOperationType(operationHistoryDto.getOperationType());
        operationsHistory.setOperationSum(operationHistoryDto.getOperationSum());
        operationsHistory.setOperationDate(operationHistoryDto.getOperationDate());
        return customConversionService.convert(operationsHistoryRepository.save(operationsHistory), OperationHistoryDto.class);
    }

    @Override
    public OperationHistoryDto getOperationHistory(Long id) {
        OperationsHistory operationsHistory = operationsHistoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Operation is not found"));
        return customConversionService.convert(operationsHistory, OperationHistoryDto.class);
    }

    @Override
    public List<OperationHistoryDto> getAll() {
        List<OperationsHistory> operationsHistories = (List<OperationsHistory>) operationsHistoryRepository.findAll();
        return operationsHistories.stream().map(operationsHistory -> customConversionService.convert(operationsHistory,OperationHistoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteOperationHistory(Long id) {
        OperationsHistory operationsHistory = operationsHistoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Operation is not found"));
        operationsHistoryRepository.delete(operationsHistory);
    }
}
