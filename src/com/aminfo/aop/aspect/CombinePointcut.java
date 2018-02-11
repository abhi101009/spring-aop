package com.aminfo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)//define order of Adviceto be execute
public class CombinePointcut {

	@Pointcut("execution(* com.aminfo.aop.aspect.dao.*.*(..))")
	public void basePointcut() {}
	
	@Pointcut("execution(* com.aminfo.aop.aspect.dao.*.get*(..))")
	public void getterPointcut() {}
	
	@Pointcut("execution(* com.aminfo.aop.aspect.dao.*.set*(..))")
	public void setterPointcut() {}
	
	@Pointcut("basePointcut() && !(getterPointcut() || setterPointcut())")
	public void noGetterSetterDeclaration() {}
	
	@Before("noGetterSetterDeclaration()")
	public void noGetterAndSetter() {
		System.out.println("== Before ASPECT====> applied on no getter and no setter");
	}

	@Before("basePointcut()")
	public void basePackageLooggingApplyEveryMethod() {
		System.out.println("== Before ASPECT====> applied on each method of bacepackage.");
	}
	
}
