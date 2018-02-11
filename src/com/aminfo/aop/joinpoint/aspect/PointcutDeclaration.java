package com.aminfo.aop.joinpoint.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class PointcutDeclaration {
	
	@Pointcut("execution(* com.aminfo.aop.joinpoint.aspect.dao.*.*(..))")
	public void basePointcut() {}
	
}
