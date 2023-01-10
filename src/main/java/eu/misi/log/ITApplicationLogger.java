package eu.misi.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ITApplicationLogger {
    @Pointcut("execution(* eu.misi..*(..))")
    public void myTraceCall() {
    }

    @Pointcut("execution(* eu.misi.*.*API(..))")
    public void apiCall() {
    }

    @Before("myTraceCall()")
    public void logBefore(JoinPoint joinPoint) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        if (logger.isInfoEnabled()) {
            logger.info("Method will start: " + joinPoint.getStaticPart().getSignature().toString());
        }
    }

    @After("myTraceCall()")
    public void logAfter(JoinPoint joinPoint) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        if (logger.isInfoEnabled()) {
            logger.info("Signiture: " + joinPoint.getStaticPart().getSignature().toString());
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                logger.info("parameter: " + joinPoint.getArgs()[i]);
            }
            logger.info("Method stoped: " + joinPoint.getSignature());
        }
    }

    @AfterReturning(pointcut = "myTraceCall()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        if (returnValue != null) {
            org.slf4j.Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
            logger.info("Return value: " + returnValue.toString());
        }
    }

    @AfterThrowing(pointcut = "apiCall()", throwing = "exception")
    public void errorInterceptor(JoinPoint joinPoint, Exception exception) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        if (logger.isInfoEnabled()) {
            logger.info("Method terminate: " + joinPoint.getSignature());
        }
        logger.error("Exception trace: ", exception);
    }
}
