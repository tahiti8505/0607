package test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gp")
public class Galaxy implements Phone {

	@Autowired
	private Watch watch;
	private int number;
	public Galaxy() {
		
	}
	public Galaxy(Watch watch,int number) {
		this.watch=watch;
		this.number=number;
	}
	
	
	
	/*
	public void initMethod() {
		System.out.println("��ü�� �ʱ�ȭ�ϴ� �۾��� ó���ϴ� �޼���...");
	}
	public void destroyMethod() {
		System.out.println("��ü �޸𸮸� �����Ҷ� ȣ���ϴ� �޼���...");
	}
	*/
	
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public void powerOn() {
		System.out.println("������ ���� ON");
	}
	@Override
	public void powerOff() {
		System.out.println("������ ���� OFF");
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
