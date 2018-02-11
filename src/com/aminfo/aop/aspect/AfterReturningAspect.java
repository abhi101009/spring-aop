package com.aminfo.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.aminfo.aop.aspect.model.Account;

@Aspect
@Component
public class AfterReturningAspect {
	
	@AfterReturning(pointcut="execution(* com.aminfo.aop.aspect.dao.AccountDao.*(..))",
			returning="result")
	public void afterReturningLog(JoinPoint theJoinPoint, Boolean result) {
		
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("==After Aspect =====> after returing from method: "+ methodSignature.toString());
		
		Object[] args = theJoinPoint.getArgs();
		System.out.println("==AfterReturning Aspect =====> after returning method arguments Size: "+ args.length);
				
		System.out.println("==AfterReturning Aspect =====> executing after returning data Result is: "+ result.toString());
		
	}
	
	@AfterReturning(pointcut="execution(* com.aminfo.aop.aspect.dao.AccountDao.findAllAccount(..))",
			returning="result")
	public void modifyDataAfterReturning(JoinPoint theJoinPoint, List<Account> result) {
		
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("==After *RETURNING* Aspect =====> after returing from method: "+ methodSignature.toString());
		
		Object[] args = theJoinPoint.getArgs();
		System.out.println("==After *RETURNING* Aspect =====> after returning method arguments Size: "+ args.length);
				
		System.out.println("==After *RETURNING* Aspect =====> executing after returning data Result is: "+ result.toString());
		
		// post processing of result, let's modify data
		appendIFSCCodeOnAccountHolderName(result);
	}

	private void appendIFSCCodeOnAccountHolderName(List<Account> result) {
		for(Account acc: result) {
			acc.setHoldenName(acc.getHoldenName()+"_SBI-009");
		}
	}
}
