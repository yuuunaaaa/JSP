package com.multi.mvc09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //스프링에서 제어하는 역할로 등록! dependency
public class FoodController {
	
	@Autowired
	//MemberDAO의 싱글톤 객체 ram의 어디에 있는지 찾아서 
	//그 주소를 아래 변수에 넣어주세요.
	FoodDAO dao; //전역변수(글로벌 변수) 
	
	@RequestMapping("insert4.multi")
	public void insert(FoodVO bag) {
		
		System.out.println("insert요청됨.");
		System.out.println(bag);
		System.out.println(dao);
		dao.insert(bag);
	}
	@RequestMapping("update4")
	public void update(FoodVO bag) {
		System.out.println("update요청됨.");
		System.out.println(bag);
		dao.update(bag);
	}
	
	@RequestMapping("delete4")
	public void delete(String id) {
		System.out.println("delete요청됨.");
		System.out.println(id);
		dao.delete(id);
	}
	
	@RequestMapping("one4")
	public void one(String id, Model model) {
		System.out.println("one요청됨.");
		System.out.println(id);
		FoodVO bag = dao.one(id);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("list4")
	public void list(Model model) {
		//Model은 컨트롤러의 list를 views/list.jsp까지만 전달할 수 있는 객체 
		//ArrayList<MemberVO> list = dao.list();
		//model.addAttribute("list", list);
	} 
}
