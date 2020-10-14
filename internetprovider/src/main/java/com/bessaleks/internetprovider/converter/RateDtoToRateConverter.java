package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.RateDto;
import com.bessaleks.internetprovider.entity.Rate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RateDtoToRateConverter implements Converter<RateDto, Rate> {
    @Override
    public Rate convert(RateDto rateDto) {
        Rate rate = new Rate();
        rate.setRateName(rateDto.getRateName());
        rate.setSpeed(rateDto.getSpeed());
        rate.setPrice(rateDto.getPrice());
        return rate;
    }
}
