package com.kim.biz.common;

import org.aspectj.lang.JoinPoint;

import com.kim.biz.member.MemberVO;

public class AfterReturningAdvice {
	public void printLogAfterReturning(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		// 현재 수행 중인 포인트컷(핵심로직, CRUD)의 메서드명
		Object[] args = jp.getArgs();
		// 현재 수행 중인 포인트컷(핵심로직, CRUD)이 사용하는 인자들의 정보

		
		System.out.println("수행중인 핵심메서드명 : " + methodName);
		System.out.println("사용하는 인자 : ");
		System.out.println("===");
		for(Object v : args) {
			System.out.println(v);
		}
		System.out.println("===");
		
		if(returnObj instanceof MemberVO) {
			MemberVO mvo = (MemberVO)returnObj;
			if(mvo.getRole().equals("ADMIN")) {
				System.out.println("관리자입니다.");
			}
			else {
				System.out.println("일반 계정입니다.");
			}
		}
		System.out.println("핵심메서드의 반환값 : " + returnObj);
	}
}
