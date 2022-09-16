package test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.park.biz.board.BoardService;
import com.park.biz.board.BoardVO;
import com.park.biz.member.MemberService;
import com.park.biz.member.MemberVO;

public class Client {
	public static void main(String[] args) {
		// Spring 컨테이너를 동작시킬 수 있도록 코드 작성
	    AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
	    
	    System.out.println("로그");
	    Scanner sc = new Scanner(System.in);
	    BoardService bs = (BoardService)factory.getBean("boardService"); // LookUp 메모리에서 객체를 '찾는' 요청
	    MemberService ms = (MemberService)factory.getBean("memberService");
	    
	    while(true) {
	    	System.out.println("1.회원가입 2.게시글 작성 3.나가기");
	    	int action = sc.nextInt();
	    	if(action==1) {
	    		while(true) {
				    MemberVO mvo = new MemberVO();
				    System.out.print("아이디 입력 : ");
				    String mid = sc.next();
				    System.out.print("비밀번호 입력 : ");
				    String mpw = sc.next();
				    System.out.print("이름 입력 : ");
				    String name = sc.next();
				    System.out.println("권한 입력 : ");
				    String role = sc.next();
				    
				    mvo.setMid(mid);
				    mvo.setMpw(mpw);
				    mvo.setName(name);
				    mvo.setRole(role);
				    ms.insertMember(mvo);
				    System.out.println("회원가입 성공");
				    break;
	    		}
	    	}
	    	else if(action==2) {
	    		while(true) {
				    MemberVO mvo = new MemberVO();
				    System.out.println("게시글을 작성하려면 로그인이 필요합니다.");
				    System.out.println("아이디 입력 : ");
				    String midLog = sc.next();
				    System.out.println("비밀번호 입력 : ");
				    String mpwLog = sc.next();
				    mvo.setMid(midLog);
				    mvo.setMpw(mpwLog);
				    mvo = ms.selectOneMember(mvo);
				    if(mvo!=null) {
				    	sc.nextLine();
				    	System.out.println("로그인 성공");
				    	System.out.println("게시글 작성하기");
					    BoardVO vo = new BoardVO();
					    
					    System.out.println("내용 작성 >>");
					    String msg =sc.nextLine();
					    
					    vo.setTitle("글제목");
					    vo.setContent(msg);
					    vo.setWriter(mvo.getMid());
					    bs.insertBoard(vo);
					    
					    List<BoardVO> datas=bs.selectAllBoard(vo);
					    for(BoardVO v : datas) {
					    	System.out.println(v);
					    }
					    break;
				    }
				    else {
				    	System.out.println("로그인 실패");
				    }
	    		}
	    	}
	    	else if(action==3) {
	    		System.out.println("종료");
	    	}
		    factory.close();
	    }
	}
}
