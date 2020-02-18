/**
 * 
 */
package com.my.interview.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuwei
 *
 */
@Component
@Aspect
@Slf4j
public class AopConfig {
	
	
	
	@Around("@annotation(com.my.interview.aop.AopTestAnnotation)")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.info("开始aop增强");
		return proceedingJoinPoint.proceed();
	}
	

}
