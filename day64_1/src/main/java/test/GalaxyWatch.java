package test;

import org.springframework.stereotype.Component;


public class GalaxyWatch implements Watch {
	public GalaxyWatch() {
		System.out.println("갤럭시 워치 객체 생성 완료");
	}
	@Override
	public void volumeUp() {
		System.out.println("갤럭시 워치 소리 ++");
	}
	@Override
	public void volumeDown() {
		System.out.println("갤럭시 워치 소리 --");
	}
}
