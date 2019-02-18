package hello.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

@Aspect
public class AspectTimer {

    @Pointcut("execution(* hello.controller.*Controller.*(..))")
    private void pointcutTimer() {

    }

    @Around(value = "pointcutTimer()")
    public Object logTimer(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("性能监测.....");
        MonitorTime monitorTime=new MonitorTime();

        //获取目标类名称
        String clazzName = joinPoint.getTarget().getClass().getName();
        //获取目标类方法名称
        String methodName = joinPoint.getSignature().getName();

        monitorTime.setClassName(clazzName);//记录类名称
        monitorTime.setMethodName(methodName);//记录对应方法名称
        monitorTime.setLogTime(new Date());//记录时间

        // 计时并调用目标函数
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long time = System.currentTimeMillis() - start;

        //设置消耗时间
        monitorTime.setComsumeTime(time);

        System.out.println("monitorTime="+monitorTime.toString());


        return result;
    }
}
