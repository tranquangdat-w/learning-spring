package com.mycompany.commentexample;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());  

    @Around("execution(* com.mycompany.commentexample.services.*.*(..))")
    public void log(ProceedingJoinPoint jointPoint) throws Throwable {
        logger.info("start");
        jointPoint.proceed();
        logger.info("end");
    }
}
