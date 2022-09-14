package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ip")
public class Iphone implements Phone{


	// 어떤 워치를 주입하는지에 따라 다른 output
	@Autowired
	private Watch watch; // 객체 멤버변수 때문에 의존관계에 있다. 의존성 주입 필요
	private int number;
	public Iphone() {
//		System.out.println("아이폰 객체 생성 완료22");
	}
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
//		System.out.println("setter 호출됨 -1");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
//		System.out.println("setter 호출됨 -2");

	}
	// 생성자 인젝션
//	public Iphone(Watch watch) {
//		this.watch=watch;
//		System.out.println("아이폰 객체 생성 완료11");
//	}
//	public Iphone(Watch watch, int number) {
//		this.watch=watch;
//		this.number=number;
//		System.out.println("아이폰 객체 생성 완료33");
//	}
	
	@Override
	public void powerOn() {
		System.out.println("아이폰 On" + number);		
	}

	@Override
	public void powerOff() {
		System.out.println("아이폰 Off");		
	}

	@Override
	public void volumeUp() {
		watch.volumeUp();	
	}

	@Override
	public void volumeDown() {
		watch.volumeDown();	
	}

}
