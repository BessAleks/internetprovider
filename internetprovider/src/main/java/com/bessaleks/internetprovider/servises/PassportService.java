package com.bessaleks.internetprovider.servises;

import com.bessaleks.internetprovider.dto.PassportDto;

import java.util.List;

public interface PassportService {
    PassportDto createPassport(PassportDto passportDto);
    PassportDto updatePassport(PassportDto passportDto);
    PassportDto getPassport(Long id);
    List<PassportDto> getAll();
    void deletePassport(Long id);
}
