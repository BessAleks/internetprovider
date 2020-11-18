package integration.bessaleks.internetprovider.repositories;

import com.bessaleks.internetprovider.InternetProviderApplication;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InternetProviderApplication.class)
@Transactional
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @Autowired
    private List<CrudRepository> repositories;

    @Before
    public void before(){
      testUser = new User();
      testUser.setEmail("abcd");
      userRepository.save(testUser);
    }

    @Test
    public void testFindByEmail(){
       Optional<Object> user= userRepository.findByEmail("abcd");
        if (user.isPresent()) {
            assertEquals(testUser, user.get());
        } else {
            Assert.fail();
        }
    }

    @After()
    public void clean() {
        repositories.forEach(CrudRepository::deleteAll);
    }

}
