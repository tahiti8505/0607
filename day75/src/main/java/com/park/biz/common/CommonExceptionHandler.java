package com.park.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 누구와 결합될지 써준다. 모든 범위.
@ControllerAdvice("com.park.biz") // CommonExceptionHandler를 객체화해주는 @
public class CommonExceptionHandler {
	
	// 전달할 정보가 있기 때문에 mav 리턴, 어떤 예외와 결합할지 써준다.
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView aException(Exception e) { // 널포인터
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView bException(Exception e) { // 수학적 문제
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView cException(Exception e) { // 미확인 에러
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
}
