package com.bessaleks.internetprovider.servises.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.OperationsHistoryRepository;
import com.bessaleks.internetprovider.repository.UserRepository;
import com.bessaleks.internetprovider.servises.MailService;
import com.bessaleks.internetprovider.servises.OperationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
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
    private final MailService mailService;


    @Autowired
    public OperationHistoryServiceImpl(OperationsHistoryRepository operationsHistoryRepository, CustomConversionService customConversionService, JavaMailSender javaMailSender, MailSender mailSender, UserRepository userRepository, MailService mailService) {
        this.operationsHistoryRepository = operationsHistoryRepository;
        this.customConversionService = customConversionService;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    @Override
    public OperationHistoryDto createOperationHistory(Long id,OperationHistoryDto operationHistoryDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User is not found"));
        OperationsHistory operationsHistory = customConversionService.convert(operationHistoryDto,OperationsHistory.class);
        user.setBalanse(user.getBalanse() + operationHistoryDto.getOperationSum());
        user.getOperationsHistories().add(operationsHistory);
        operationsHistory.setUser(user);
        mailService.send(user.getEmail(),"Operation " + operationsHistory.getOperationType(),"Operation " + operationsHistory.getOperationType() + " for the sum: " + operationsHistory.getOperationSum() + " is successfully!\n" + "Time of operation: " + operationsHistory.getOperationDate());
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