package com.bessaleks.internetprovider.aspect;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.OperationsHistoryRepository;
import com.bessaleks.internetprovider.repository.UserRepository;
import com.bessaleks.internetprovider.servises.MailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProjectAspect {
    private final MailService mailService;
    private final UserRepository userRepository;
    private final OperationsHistoryRepository operationsHistoryRepository;
    private final CustomConversionService customConversionService;

    @Autowired
    public ProjectAspect(MailService mailService, UserRepository userRepository, OperationsHistoryRepository operationsHistoryRepository, CustomConversionService customConversionService) {
        this.mailService = mailService;
        this.userRepository = userRepository;
        this.operationsHistoryRepository = operationsHistoryRepository;
        this.customConversionService = customConversionService;
    }

    @Pointcut("execution(* com.bessaleks.internetprovider.servises.impl.OperationHistoryServiceImpl.createOperationHistory(..))")
    public void callAtOperationHistoryServicePublic() { }

    @AfterReturning(value = "callAtOperationHistoryServicePublic() && args(operationHistoryDto)")
    public void afterCallAtCreateOperationHistory(JoinPoint joinPoint, com.bessaleks.internetprovider.dto.OperationHistoryDto operationHistoryDto) {
        User user = userRepository.findById(operationHistoryDto.getUserDto().getId()).orElseThrow(() -> new NotFoundException("User is not found"));
        OperationsHistory operationsHistory = customConversionService.convert(operationHistoryDto,OperationsHistory.class);
        mailService.send(user.getEmail(),"Operation " + operationsHistory.getOperationType(),"Operation " + operationsHistory.getOperationType() + " for the sum: " + operationsHistory.getOperationSum() + " is successfully!\n" + "Time of operation: " + operationsHistory.getOperationDate());
    }

    @AfterThrowing(value = "callAtOperationHistoryServicePublic()",throwing = "ex")
    public String sendMailFailed(Throwable ex){
        return "Operation failed! " + ex;
    }

}
