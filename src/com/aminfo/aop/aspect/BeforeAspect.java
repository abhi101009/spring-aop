package com.aminfo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)//define order of Advice to be execute
public class BeforeAspect {
	
	//@Before("execution(public void addAccount(String))")  for any addAccount method
	//@Before("execution(public void com.aminfo.aop.before.dao.AccountDao.addAccount(String))") // for specific class addAccount method
	//@Before("execution(public void com.aminfo.aop.before.dao.AccountDao.add*(String))") // for specific class name pattern
	//@Before("execution(* add*(String))") // for any class any method name having pattern (method name start with "add")
	@Before("execution(* add*(.., Integer))") // patter for method arguments
	public void aspectAdviceBefore() {
		System.out.println("=== Before ASPECT====> "+getClass().getName() + " varify user detail in gov using aspect before.");
	}

	@Before("execution(* com.aminfo.aop.before.dao.*.*(..))") // patter for any class any method within define package
	public void aspectAdviceBeforeAnyMethodOfDao () {
		System.out.println("==== Before ASPECT======> "+ getClass().getName() + " appplied for package com.aminfo.aop.before.dao any class any method ");
	}
	

}
