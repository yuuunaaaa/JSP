package com.multi.mvc04;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링에서 제어하는 역할로 등록!
public class MemberController {

	@Autowired // MemberDAO의 싱글톤 객체 ram의 어디에 있는지 찾아서 그 주소를 아래 변수에 넣어주세요
	MemberDAO dao; // 전역변수(글로벌 변수)

	// 컨트롤 하는 기능(CRUD)
	// 회원가입, 수정, 탈퇴, 정보검색

	@RequestMapping("login")
	public String login(MemberVO bag) {
		System.out.println(bag);
		// dao를 이용해서 db처리할 예정
		// views아래로 넘어가게 되어있음
		// views아래 login.jsp를 호풀
		int result = dao.login(bag);
		if (result == 1) {
			return "ok"; // views 아래 파일
		} else {
			// views 아래가 아니고, 
			return "redirect:member.jsp";
		}
	}

	// 클래스 내에서 기능처리 담당
	// 멤버변수 + 멤버메서드(기능처리 담당)
	// 하나의 요청당 하나의 메서드
	// 하나의 버튼호출당 하나의 함수 연결!
	// 요청된 주소가 어떻게 될 때
	// 바로 아래에 있는 메서드가 호출이 될지를
	// 써주어야 한다.
	@RequestMapping("insert")
	public void insert(MemberVO bag) {
		// 메서드의 입력변수(파라메터)로 변수를
		// 선언해두면, 컨트롤러내의 메서드내에서는
		// 1)bag을 만들어서
		// 2)클라이언트로 부터 전달된 데이터도 받아줌.
		// 3)bag에 데이터 다 넣어줌.
		System.out.println("insert요청됨.");
		System.out.println(bag);
		System.out.println(dao);
		// MemberDAO dao - new MemberDAO();
		// dao에게 insert 요청!!
		dao.insert(bag);
	}

	@RequestMapping("update")
	public void update(MemberVO bag) {
		System.out.println("update요청됨.");
		System.out.println(bag);
		dao.update(bag);
	}

	@RequestMapping("delete")
	public void delete(String id) {
		System.out.println("delete요청됨.");
		System.out.println(id);
		dao.delete(id);
	}

	@RequestMapping("one")
	public void one(String id, Model model) {
		System.out.println("one요청됨.");
		System.out.println(id);
		MemberVO bag = dao.one(id);
		//bag에 검색결과 다 들어있음
		model.addAttribute("bag", bag);
	}

	@RequestMapping("list")
	public void list(Model model) {
		// Model은 컨트롤러의 list를  views/list.jsp까지만 전달할 수 있는 객체
		ArrayList<MemberVO> list = dao.list();
		model.addAttribute("list", list);
	}

	// https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%8F%99%EC%B0%A8

}