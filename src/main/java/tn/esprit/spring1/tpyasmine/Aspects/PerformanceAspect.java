package tn.esprit.spring1.tpyasmine.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around("execution(* tn.esprit.spring1.tpyasmine.Service.ICoursServiceImp.findAll())")
    public Object executionTime(ProceedingJoinPoint pjp) throws Throwable {
        long t1 = System.currentTimeMillis();

        Object obj = pjp.proceed();
        long executionTime = System.currentTimeMillis() - t1;

        String methodName = pjp.getSignature().getName();
        log.info("The runtime of the method (" + methodName + ") = " + executionTime + " milliseconds.");

        return obj;
    }
}
