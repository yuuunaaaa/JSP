package com.multi.mvc09;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //스프링에서 제어하는 역할로 등록! 
public class BbsController {

	@Autowired
	BbsDAO dao;

	@RequestMapping("insert2.multi")
	public void insert(BbsVO bag) {
		System.out.println("insert요청됨.");
		System.out.println(bag);
		System.out.println(dao);
		
		//dao에게 insert요청!!
		dao.insert(bag);
	}
	
	@RequestMapping("update2.multi")
	public void update(BbsVO bag) {
		System.out.println("update요청됨.");
		System.out.println(bag);
		System.out.println(dao);
		
		//dao에게 insert요청!!
		dao.update(bag);
	}
	
	@RequestMapping("delete2.multi")
	public void delete(int no) {
		System.out.println("delete요청됨.");
		System.out.println(no);
		System.out.println(dao);
		
		//dao에게 insert요청!!
		dao.delete(no);
	}
//	@RequestMapping("update")
//	public void update(BbsVO bag) {
//		System.out.println("update요청됨.");
//		System.out.println(bag);	
//		dao.update(bag);
//	}
//	
//	@RequestMapping("delete")
//	public void delete(int no) {
//		System.out.println("delete요청됨.");
//		System.out.println(no);
//		dao.delete(no);
//	}
//	
//	@RequestMapping("one6")
//	public void one6(int no, Model model) {
//		System.out.println("one요청됨.");
//		System.out.println(no);
//		//BbsVO bag = dao.one(no);
//		//검색결과가 있는지 프린트!
//		//System.out.println(bag);
//		//model.addAttribute("bag", bag);
//	}
//	
//	@RequestMapping("list5")
//	public void list(Model model) {
//		//ArrayList<BbsVO> list = dao.list();
//		//System.out.println(list.size()); //사이즈를 찍어보세요.
//		//model.addAttribute("list", list);
//	}
	
	//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%8F%99%EC%B0%A8	
}