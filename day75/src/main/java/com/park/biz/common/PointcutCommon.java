package com.park.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.park.biz..*Impl.*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* com.park.biz..*Impl.select*(..))")
	public void bPointcut() {}
}
