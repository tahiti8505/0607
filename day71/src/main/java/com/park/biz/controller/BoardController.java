package com.park.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.park.biz.board.BoardService;
import com.park.biz.board.BoardVO;

@Controller
@SessionAttributes("data")
public class BoardController {
	
	@Autowired
	private BoardService boardService; // 비즈니스 컴포넌트. DAO를 직접 이용 XXX
	
	// 검색 관련 Map 제공
	@ModelAttribute("scMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> scMap = new HashMap<String,String>();
		scMap.put("제목", "title");
		scMap.put("작성자", "writer");
		// view에서 어떻게 보여야하는지, 실제로 모델에서 어떤 값으로 쓰는지를 컨트롤러에서 지정
		// model.addAttribute가 된 상태로 return, 그래서 View에서 사용 가능하다. 
		return scMap;
	}
	
	@RequestMapping("/board.do")
	public String selectOneBoard(BoardVO bvo, Model model, HttpServletRequest request) {
		bvo = boardService.selectOneBoard(bvo);
		model.addAttribute("data", bvo);
		
		return "boardForm.jsp";
	}
	
	@RequestMapping("/main.do")
	public String selectAllBoard(@RequestParam(value="searchCondition", defaultValue="title",required=false)String searchCondition, @RequestParam(value="searchContent", defaultValue="",required=false)String searchContent, BoardVO bvo, Model model, HttpServletRequest request) {
		// Commmand 객체의 멤버 변수로 SearchContent, SearchCondition이 없어서 자동 매핑이 안된다.
		// 자바에서만 사용할 목적으로 VO에 멤버 변수로 추가
		// @RequestParam 사용
	
		System.out.println("검색 조건 : " + searchCondition);
		System.out.println("검색어 : " + searchContent);
		List<BoardVO> datas = null;
		if(searchCondition.equals("title")) {
			bvo.setTitle(searchContent);
			datas = boardService.selectAllBoardT(bvo);

		}
		else if(searchCondition.equals("writer")) {
			bvo.setContent(searchContent);
			datas = boardService.selectAllBoardW(bvo);

		}
		else {
			datas = boardService.selectAllBoard(bvo);
		}
		model.addAttribute("datas",datas);

		return "main.jsp";
	}
	@RequestMapping("/deleteB.do")
	public String deleteBoard(BoardVO bvo, HttpServletRequest request) {
		boardService.deleteBoard(bvo);
		
		return "redirect:main.do";
	}
	@RequestMapping("/updateB.do")
	public String updateBoard(@ModelAttribute("data")BoardVO bvo, HttpServletRequest request) {
		MultipartFile uploadFile=bvo.getUploadFile();
		if(!uploadFile.isEmpty()) { // 업로드한 파일 존재여부 확인
			String fileName = uploadFile.getOriginalFilename(); // 업로드한 파일명
			System.out.println(fileName);
			try {
				uploadFile.transferTo(new File("D:\\PSJ\\workspace\\day71\\src\\main\\webapp\\images\\"+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // 파일의 저장 경로 설정 가능
			bvo.setFileName(fileName);
		}
		System.out.println("update 인자 " + bvo);
		boardService.updateBoard(bvo);
		
		return "redirect:main.do";
	}
	@RequestMapping("/insertB.do")
	public String insertBoard(BoardVO bvo) throws IllegalStateException, IOException {
		MultipartFile uploadFile=bvo.getUploadFile();
		if(!uploadFile.isEmpty()) { // 업로드한 파일 존재여부 확인
			String fileName = uploadFile.getOriginalFilename(); // 업로드한 파일명
			System.out.println(fileName);
			uploadFile.transferTo(new File("D:\\PSJ\\workspace\\day71\\src\\main\\webapp\\images\\"+fileName)); // 파일의 저장 경로 설정 가능
			bvo.setFileName(fileName);
		}
		boardService.insertBoard(bvo);
		return "redirect:main.do";
	}
}
