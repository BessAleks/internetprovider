package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.Passport;
import com.bessaleks.internetprovider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {
    private final CustomConversionService customConversionService;

    @Autowired
    public UserDtoToUserConverter(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        return user;
    }
}
