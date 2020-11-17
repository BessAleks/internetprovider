package unit.bessaleks.internetprovider.servicies.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.repository.PassportRepository;
import com.bessaleks.internetprovider.repository.UserRepository;
import com.bessaleks.internetprovider.servises.impl.PassportServiceImpl;
import com.bessaleks.internetprovider.servises.impl.UserServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PassportServiceImplTest {
    @InjectMocks
    private PassportServiceImpl passportService;

    @Mock
    private PassportRepository passportRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CustomConversionService customConversionService;

    @Ignore
    @Test
    public void testCreatePassport(){
        PassportDto passportDto = new PassportDto();
        passportService.createPassport(passportDto);
    }


}
