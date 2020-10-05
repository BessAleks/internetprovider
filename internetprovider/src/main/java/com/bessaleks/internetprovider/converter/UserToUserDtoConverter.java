package com.bessaleks.internetprovider.converter;


import com.bessaleks.internetprovider.dto.AddressDto;
import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    private final CustomConversionService customConversionService;

    @Autowired
    public UserToUserDtoConverter(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }

    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setPassportDto(customConversionService.convert(user.getPassport(), PassportDto.class));
        userDto.setAddressDtos(customConversionService.convert(user.getAddress(), AddressDto.class));
        userDto.setOperationHistoryDtos(customConversionService.convert(user.getOperationsHistories(), OperationHistoryDto.class));
        return userDto;
    }
}
