package com.bessaleks.internetprovider.converter;


import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.Passport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PassportToPassportDtoConverter implements Converter<Passport, PassportDto> {

    private final CustomConversionService customConversionService;

    @Autowired
    public PassportToPassportDtoConverter(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }

    @Override
    public PassportDto convert(Passport passport) {
        PassportDto passportDto = new PassportDto();
        passportDto.setName(passport.getName());
        passportDto.setSurname(passport.getSurname());
        passportDto.setLastName(passport.getLastName());
        passportDto.setPassportNumber(passport.getPassportNumber());
        passportDto.setPassportIssuedBy(passport.getPassportIssuedBy());
        passportDto.setPassportIssued(passport.getPassportIssued());
        passportDto.setBirthday(passport.getBirthday());
        passportDto.setSex(passport.getSex());
        passportDto.setUserDto(customConversionService.convert(passport.getUser(), UserDto.class));
        return passportDto;
    }
}
