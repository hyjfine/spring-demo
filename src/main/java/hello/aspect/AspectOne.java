package hello.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectOne {

    @Before(value = "pointcutAddUser() && args(name)", argNames = "name")
    public void before(String name) {
        System.out.println("前置通知-----" + " || " + name);
    }

    @AfterReturning(value = "pointcutAddUser()", returning = "object")
    public void AfterReturning(Object object) {
        System.out.println("返回后通知-----" + object);
    }

    @Around(value = "pointcutAddUser()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前------");
        Object object = joinPoint.proceed();
        System.out.println("环绕通知后------");
        return object;
    }

    @AfterThrowing(value = "pointcutAddUser()", throwing = "throwable")
    public void throwable(Throwable throwable) {
        System.out.println("Throwable------" + throwable);
    }

    @After(value = "pointcutAddUser()")
    public void after() {
        System.out.println("结束通知--------");
    }

    @Pointcut("execution(* hello.aspect.UserDao.addUser(..))")
    private void pointcutAddUser() {

    }


}
