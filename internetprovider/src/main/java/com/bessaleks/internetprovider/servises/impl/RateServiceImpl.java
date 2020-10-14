package com.bessaleks.internetprovider.servises.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.ContractDto;
import com.bessaleks.internetprovider.dto.RateDto;
import com.bessaleks.internetprovider.entity.Contract;
import com.bessaleks.internetprovider.entity.Rate;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.RateRepository;
import com.bessaleks.internetprovider.servises.RateService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;
    private final CustomConversionService customConversionService;

    public RateServiceImpl(RateRepository rateRepository, CustomConversionService customConversionService) {
        this.rateRepository = rateRepository;
        this.customConversionService = customConversionService;
    }

    @Override
    public RateDto createRate(RateDto rateDto) {
        Rate rate = customConversionService.convert(rateDto,Rate.class);
        return customConversionService.convert(rateRepository.save(rate), RateDto.class);
    }

    @Override
    public RateDto updateRate(RateDto rateDto) {
        Rate rate = rateRepository.findById(rateDto.getId()).orElseThrow(() -> new NotFoundException("Rate is not found"));
        rate.setRateName(rateDto.getRateName());
        rate.setSpeed(rateDto.getSpeed());
        rate.setPrice(rateDto.getPrice());
        return customConversionService.convert(rateRepository.save(rate), RateDto.class);
    }

    @Override
    public RateDto getRate(Long id) {
        Rate rate = rateRepository.findById(id).orElseThrow(() -> new NotFoundException("Rate is not found"));
        return customConversionService.convert(rate, RateDto.class);
    }

    @Override
    public List<RateDto> getAll() {
        List<Rate> rates = (List<Rate>) rateRepository.findAll();
        return rates.stream().map(rate -> customConversionService.convert(rateRepository,RateDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteRate(Long id) {
        Rate rate = rateRepository.findById(id).orElseThrow(() -> new NotFoundException("Rate is not found"));
        rateRepository.delete(rate);
    }
}
