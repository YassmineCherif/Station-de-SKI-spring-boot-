package tn.esprit.spring1.tpyasmine.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j //heya li taatina log
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning(pointcut = "execution(* tn.esprit.spring1.tpyasmine.*Controller.*(..))", returning = "result")
    public void logControllerMethods(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Controller Method: {} returned {}", methodName, result);
    }

    @AfterReturning(pointcut = "execution(* tn.esprit.spring1.tpyasmine.*Service.*(..))", returning = "result")
    public void logServiceMethods(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Service Method: {} returned {}", methodName, result);
    }

    @Before("execution(* tn.esprit.spring1.tpyasmine.Service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().toShortString();

        log.info("In method :" + name);
    }
        @After("execution(* tn.esprit.spring1.tpyasmine.Service.*.*(..))")
        public void logMethodExit(JoinPoint joinPoint) {

            String name = joinPoint .getSignature().toShortString();

            log.info("Out of method :" + name );

        }

}
