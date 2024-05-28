package mainAPP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.text.DateFormat;

@Aspect
@Component
@EnableAspectJAutoProxy

public class LoggingAspect {
	 @Pointcut("execution(* command..*(..))")
	    public void allMethodsIn() {}

	    @Before("allMethodsIn()")
	    public void logBefore(JoinPoint joinPoint) {
	        System.out.println("\tLogging before method execution: " + joinPoint.getSignature().getName());
	    }

	    @After("allMethodsIn()")
	    public void logAfter(JoinPoint jp) {
	        System.out.println("\tAfter method: " + jp.getSignature().getName());
	    }

	

}
