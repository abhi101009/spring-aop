package com.aminfo.aop.joinpoint.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspactAdvice {

	@Before("com.aminfo.aop.joinpoint.aspect.PointcutDeclaration.basePointcut()")
	public void getMethodSignatureJoinPoint(JoinPoint theJoinPoint) {
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
				
		System.out.println("Aspect is executing =====>method signature: "+ methodSign.toString());
		
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArgs: args) {
			System.out.println(tempArgs);
		}
	}
}
