package test;

public class Iphone implements Phone{
	private AppleWatch watch;
	private int number;
	public Iphone() {
		System.out.println("아이폰 객체 생성 완료22");
	}
	public Iphone(AppleWatch watch) {
		this.watch=watch;
		System.out.println("아이폰 객체 생성 완료11");
	}
	public Iphone(AppleWatch watch, int number) {
		this.watch=watch;
		this.number=number;
		System.out.println("아이폰 객체 생성 완료33");
	}
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
