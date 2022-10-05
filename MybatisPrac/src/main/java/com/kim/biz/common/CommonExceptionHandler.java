package com.kim.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.kim.biz") // CommonExceptionHandler�� ��üȭ���ִ� @
public class CommonExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView aException(Exception e) { // ���������ͼ���
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView bException(Exception e) { // �������� ����
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView cException(Exception e) { // ��Ȯ�� ����
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}

}
