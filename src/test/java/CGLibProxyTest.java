import hello.proxy.CGLibProxy;
import hello.proxy.User;
import org.junit.Test;

public class CGLibProxyTest {


    @Test
    public void testProxy() {
        User user = new User();

        CGLibProxy cgLibProxy = new CGLibProxy(user);

        User userProxy = cgLibProxy.createProxy();

        userProxy.say();

    }
}
