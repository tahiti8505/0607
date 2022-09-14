package test;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		// Spring 컨테이너를 동작시킬 수 있도록 코드 작성
	    AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
	    System.out.println("로그");
	    Phone phone = (Phone)factory.getBean("ip");
	    phone.volumeDown();
	    factory.close();
	    
//	    Map<String, String> datas = tb.getDatas();
//	    // datas 자체를 출력해도 컬렉션이니 출력 가능
//	    System.out.println(datas);
	    
	    // Spring 컨테이너야, 나 폰 객체 갖고 싶어
	    // == Lookup == 객체요청 : 컨테이너야, 가지고 있는 개체중에서 이름이 "phone1"인 객체를 줘
//	    Phone phone = (Phone)factory.getBean("phone");
//	    phone.powerOn();
//	    phone.volumeUp();
//	    phone.volumeDown();
//	    phone.powerOff();
//	    factory.close();
	
//		BeanFactory bf = new BeanFactory();
//		Phone phone = (Phone)bf.getBean(args[0]);
//		phone.powerOn();
//		phone.powerOff();
//		phone.volumeDown();
//		phone.volumeUp();
	}
}
