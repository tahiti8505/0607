package com.park.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	// DispatcherServlet과 HandlerMapping, viewResolver 간의 의존 관계가 발생
	// init 메서드를 통해 주입한다.
	
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		
		// 현재 경로와 jsp 여부, setter 주입
		viewResolver.setPrefix("./");;
		viewResolver.setSuffix(".jsp");
	}
	
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doAction(request, response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getRequestURI();
		command=command.substring(command.lastIndexOf("/"));
		System.out.println(command);
		
		Controller ctrl = handlerMapping.getController(command);
		String viewName = ctrl.handleRequest(request, response);
		
		String view=null;
		if(viewName.equals(".do")) {
			view=viewName;
		}
		else {
			view=viewResolver.getView(viewName);
		}
		response.sendRedirect(view);
	}

}
