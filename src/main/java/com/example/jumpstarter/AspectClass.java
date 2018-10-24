package com.example.jumpstarter;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author alexandru.lungu
 */


@Aspect
@Component
public class AspectClass {

    @Around("@annotation(LogMetricsInfo)")
    public Object doLogInfo(ProceedingJoinPoint proceedingPoint) {
        long startTime = System.currentTimeMillis();
        System.out.println("start recording...");
        Object proceed = null;
        try {
            proceed = proceedingPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("stop, delta time: " + String.valueOf(System.currentTimeMillis() - startTime));

        return proceed;
    }

}
