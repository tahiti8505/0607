package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gp")
public class Galaxy implements Phone {
	
	@Autowired
	private Watch watch;
	private String battery;
	
//	public Galaxy(Watch watch) {
//		this.watch=watch;
//		System.out.println("갤럭시 생성자 생성11");
//
//	}
	public Galaxy() {
		System.out.println("갤럭시 생성자 생성");
		
	}
//	public Galaxy(Watch watch, String battery) {
//		this.watch=watch;
//		this.battery=battery;
//		System.out.println("갤럭시 생성자 생성22");
//
//	}
	
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
		System.out.println("setter 호출됨 - 1");
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
		System.out.println("setter 호출됨 - 2");
	}
	public void initMethod() {
		System.out.println("객체를 초기화하는 작업을 처리하는 메서드");
	}
	public void destroyMethod() {
		System.out.println("객체 메모리를 해제할 때 호출하는 메서드");
	}
	@Override
	public void powerOn() {
		System.out.println("갤럭시 전원 ON " + battery);
	}
	@Override
	public void powerOff() {
		System.out.println("갤럭시 전원 OFF");
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
