package com.aminfo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)//define order of Adviceto be execute
public class PointcutDeclaration {

	
	@Pointcut("execution(* com.aminfo.aop.aspect.dao.*.*(..))") // pattern for method arguments
	public void commonExpression() {}

	@Before("commonExpression()")
	public void adviceOne() {
		System.out.println("== Before ASPECT====> advice One.");
	}

	@Before("commonExpression()")
	public void adviceTwo() {
		System.out.println("== Before ASPECT====> advice Two.");
	}
	
}
