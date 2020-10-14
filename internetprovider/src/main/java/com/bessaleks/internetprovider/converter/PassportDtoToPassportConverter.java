package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.entity.Passport;
import com.bessaleks.internetprovider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PassportDtoToPassportConverter implements Converter<PassportDto, Passport> {
    private final CustomConversionService customConversionService;

    @Autowired
    public PassportDtoToPassportConverter(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }

    @Override
    public Passport convert(PassportDto passportDto) {
        Passport passport = new Passport();
        passport.setName(passportDto.getName());
        passport.setSurname(passportDto.getSurname());
        passport.setLastName(passportDto.getLastName());
        passport.setPassportNumber(passportDto.getPassportNumber());
        passport.setPassportIssuedBy(passportDto.getPassportIssuedBy());
        passport.setPassportIssued(passportDto.getPassportIssued());
        passport.setBirthday(passportDto.getBirthday());
        passport.setSex(passportDto.getSex());
        return passport;
    }
}
