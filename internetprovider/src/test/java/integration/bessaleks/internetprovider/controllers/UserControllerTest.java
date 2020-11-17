package integration.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.InternetProviderApplication;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.servises.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.mockito.Mockito;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InternetProviderApplication.class)
public class UserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;


    @Before
    public void setUp(){
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {
        UserDto inputUser = new UserDto();
        inputUser.setEmail("abcde");
        UserDto outputUser = new UserDto();
        outputUser.setEmail("abcd");
        Mockito.when(userService.createUser(inputUser)).thenReturn(outputUser);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper
                        .writer()
                        .writeValueAsString(inputUser)))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andReturn();
        UserDto resultUser = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),UserDto.class);
        Assert.assertEquals(outputUser,resultUser);
    }
}
