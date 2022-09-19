package test2;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kim.biz.board.BoardService;
import com.kim.biz.board.BoardVO;
import com.kim.biz.member.MemberService;
import com.kim.biz.member.MemberVO;

public class Client {
	public static void main(String[] args) {
		// Spring �����̳ʸ� ���۽�ų���ֵ��� �ڵ��ۼ�
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		Scanner sc=new Scanner(System.in);
		BoardService bs=(BoardService)factory.getBean("boardService");
		BoardVO vo=new BoardVO();
		System.out.print("내용 작성 >> ");
		String msg=sc.nextLine();
		vo.setContent(msg);
		vo.setTitle("글제목");
		vo.setWriter("작성자");
		bs.insertBoard(vo);
		
		List<BoardVO> datas=bs.selectAllBoard(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		MemberService ms=(MemberService)factory.getBean("memberService"); // Lookup == �޸𸮿��� ��ü�� "ã��" ��û

		System.out.print("아이디 >> ");
		String mid=sc.next();
		System.out.print("비밀번호>> ");
		String mpw=sc.next();
		MemberVO mvo=new MemberVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		mvo=ms.selectOneMember(mvo);
		if(mvo==null) {
			System.out.println("로그인 실패..");
		}
		else {
			System.out.println(mvo.getName()+"님 안녕하세요 :D");
		}

		factory.close();
		
		// Spring �����̳ʾ�, �� �� ��ü�� ������;�!
		// == Lookup == ��ü��û: �����̳ʾ�, �������ִ� ��ü�߿��� �̸��� "phone"�� ��ü�� ��!
		/*
		Phone phone=(Phone)factory.getBean("gp");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		factory.close();
		*/
		
		/*
		BeanFactory bf=new BeanFactory();
		Phone phone=(Phone)bf.getBean(args[0]);
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		*/
	}
}
