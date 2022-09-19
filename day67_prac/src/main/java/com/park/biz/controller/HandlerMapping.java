package com.park.biz.controller;

import java.util.HashMap;
import java.util.Map;


public class HandlerMapping {
	// input : 어떤 요청에 대해 == String
	// output : 무슨 Controller 객체를 제공해야 하는지 == Controller
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/login.do", new LoginController()); // 싱글톤 패턴 유지
	}
	
	public Controller getController(String command) {
		return mappings.get(command);
	}
}
