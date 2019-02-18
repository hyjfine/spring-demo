import hello.aspect.UserDao;
import hello.aspect.UserDapImp;
import hello.proxy.JDKProxy;
import org.junit.Test;

public class JDKProxyTest {

    @Test
    public void testJDK() {
        UserDao user = new UserDapImp();

        JDKProxy jdkProxy = new JDKProxy(user);

        UserDao userProxy = jdkProxy.createProxy();

        userProxy.addUser("lily");

    }
}
