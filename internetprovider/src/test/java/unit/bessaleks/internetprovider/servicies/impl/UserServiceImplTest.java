package unit.bessaleks.internetprovider.servicies.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.Passport;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.repository.*;
import com.bessaleks.internetprovider.servises.impl.UserServiceImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private PassportRepository passportRepository;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private OperationsHistoryRepository operationsHistoryRepository;
    @Mock
    private CustomConversionService customConversionService;
    @Mock
    private AuthorityRepository authorityRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Before
    public void beforeTest(){
    }

    @After
    public void afterTest(){
    }

    @BeforeClass
    public static void beforeClassTest(){
    }

    @AfterClass
    public static void afterClassTest(){
    }

    @Test//(expected = NullPointerException.class, timeout = 10000)
    public void testCreateUser(){
        UserDto inputUserDto = new UserDto();
        inputUserDto.setId(1l);
        inputUserDto.setPhone("123456");
        inputUserDto.setEmail("abcd");
        UserDto outputUserDto = new UserDto();
        User convertedUser= new User();
        User savedUser = new User();
        Mockito.when(customConversionService.convert(inputUserDto,User.class)).thenReturn(convertedUser);
        //Mockito.when(customConversionService.convert(ArgumentMatchers.any(UserDto.class), ArgumentMatchers.eq(User.class))).thenReturn(convertedUser);
        Mockito.when(userRepository.save(convertedUser)).thenReturn(savedUser);
        Mockito.when(customConversionService.convert(savedUser,UserDto.class)).thenReturn(outputUserDto);
        UserDto result = userService.createUser(inputUserDto);
        Assert.assertSame(outputUserDto,result);
        Mockito.verify(customConversionService, Mockito.times(1)).convert(inputUserDto, User.class);
        Mockito.verify(userRepository, Mockito.times(1)).save(convertedUser);
    }

    @Test
    public void testSingUp(){
        String email = "asdf";
        String password = "1234";
        String phone = "89012223344";
        try {
            userService.signUp(email,password,phone);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
