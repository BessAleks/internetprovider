package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.ContractDto;
import com.bessaleks.internetprovider.dto.RateDto;
import com.bessaleks.internetprovider.entity.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RateToRateDtoConverter implements Converter<Rate, RateDto> {
    private final CustomConversionService customConversionService;
    @Autowired
    public RateToRateDtoConverter(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }

    @Override
    public RateDto convert(Rate rate) {
        RateDto rateDto = new RateDto();
        rateDto.setRateName(rate.getRateName());
        rateDto.setSpeed(rate.getSpeed());
        rateDto.setPrice(rate.getPrice());
        rateDto.setContractDto(customConversionService.convert(rate.getContract(), ContractDto.class));
        return rateDto;
    }
}
