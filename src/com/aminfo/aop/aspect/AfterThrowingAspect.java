package com.aminfo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AfterThrowingAspect {

	@AfterThrowing(pointcut=("execution(* com.aminfo.aop.aspect.dao.*.*(..))"),throwing="theException")
	public void exceptionThrown(JoinPoint theJoinPoint, Throwable theException) {
		
		System.out.println("== ASPECT *THROWING*======> Exception found in code: "+theException.getMessage());
	}
}
