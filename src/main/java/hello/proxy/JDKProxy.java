package hello.proxy;


import hello.aspect.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private UserDao target;

    public JDKProxy(UserDao target) {
        this.target = target;
    }

    public UserDao createProxy() {
        return (UserDao) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("addUser".equals(method.getName())) {
            System.out.println("JDKProxy invoke ----------");

            return method.invoke(target, args);
        }
        return method.invoke(target, args);
    }
}
