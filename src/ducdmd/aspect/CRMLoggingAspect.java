package ducdmd.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* ducdmd.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* ducdmd.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* ducdmd.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(
			JoinPoint joinPoint
			) {
		// display the method that we call
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("===>>> in @Before: calling method: " + method);
		
		// display the arguments to the method
		Object[] args = joinPoint.getArgs();
		
		for(Object arg : args) {
			myLogger.info("> argument: " + arg.getClass() + " : " + arg);
		}
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result"
			)
	public void afterReturning(
			JoinPoint joinPoint,
			Object result
			) {
		// display the method we are returning from
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("===>>> in @AfterReturning from: " + method);
		// display data returned
		myLogger.info(">>> RESULT: " + result);
	}
}
