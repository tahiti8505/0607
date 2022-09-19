package test2;

public class AppleWatch implements Watch {
	public AppleWatch() {
		System.out.println("���ÿ�ġ ��ü�����Ϸ�");
	}
	@Override
	public void volumeUp() {
		System.out.println("���ÿ�ġ ++");
	}
	@Override
	public void volumeDown() {
		System.out.println("���ÿ�ġ --");
	}
}
