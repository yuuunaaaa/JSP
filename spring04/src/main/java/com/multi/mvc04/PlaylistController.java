package com.multi.mvc04;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //스프링에서 제어하는 역할로 등록! 
public class PlaylistController {
	@Autowired
	PlaylistDAO dao;

	@RequestMapping("insert5.multi")
	public void insert(PlaylistVO bag) {
		//메서드의 입력변수(파라메터)로 변수를
		//선언해두면, 컨트롤러내의 메서드내에서는
		//1)bag을 만들어서 
		//2)클라이언트로 부터 전달된 데이터도 받아줌.
		//3)bag에 데이터 다 넣어줌.
		System.out.println("insert요청됨.");
		System.out.println(bag);
		
		//dao에게 insert요청!!
		dao.insert(bag);
	}
	
	@RequestMapping("update5.multi")
	public void update(PlaylistVO bag) {
		System.out.println("update요청됨.");
		System.out.println(bag);	
		dao.update(bag);
	}
	
	@RequestMapping("delete5.multi")
	public void delete(String id) {
		System.out.println("delete요청됨.");
		System.out.println(id);
		dao.delete(id);
	}
	
	@RequestMapping("one5.multi")
	public void one(String id, Model model) {
		System.out.println("one요청됨.");
		PlaylistVO bag = dao.one(id);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("list5")
	public void list(Model model) {
		ArrayList<PlaylistVO> list = dao.list();
		System.out.println("사이즈 : " + list.size());
		model.addAttribute("list", list);
	}
	
	//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%8F%99%EC%B0%A8
}