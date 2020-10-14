package com.bessaleks.internetprovider.servises;

import com.bessaleks.internetprovider.dto.RateDto;

import java.util.List;

public interface RateService {
    RateDto createRate(RateDto rateDto);
    RateDto updateRate(RateDto rateDto);
    RateDto getRate(Long id);
    List<RateDto> getAll();
    void deleteRate(Long id);
}
