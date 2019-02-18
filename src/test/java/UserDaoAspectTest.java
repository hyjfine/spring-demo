import hello.aspect.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/aspects.xml")
public class UserDaoAspectTest {

    @Autowired
    UserDao userDao;

    @Test
    public void aspectTest() {
        userDao.addUser( "lilei");
    }
}
