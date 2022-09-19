package test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ip")
public class IPhone implements Phone{
	@Autowired
	private Watch watch; // �������� -> ������ ����(DI)�� �ʿ��� ����
	private int number;
	public IPhone() {
		System.out.println("������ ��ü�����Ϸ�");
	}
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
		System.out.println("setter ȣ��� - 1");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		System.out.println("setter ȣ��� - 2");
	}

	/*
	// DI: ������ ������
	public IPhone(Watch watch) {
		System.out.println("������ ��ü�����Ϸ�22");
		this.watch=watch;
	}
	public IPhone(Watch watch,int number) {
		System.out.println("������ ��ü�����Ϸ�333");
		this.watch=watch;
		this.number=number;
	}
	*/
	@Override
	public void powerOn() {
		System.out.println("������ ���� ON : "+this.number);
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
