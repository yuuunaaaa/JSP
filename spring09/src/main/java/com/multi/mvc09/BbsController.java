package com.multi.mvc09;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���������� �����ϴ� ���ҷ� ���! 
public class BbsController {

	@Autowired
	BbsDAO dao;

	@RequestMapping("insert2.multi")
	public void insert(BbsVO bag) {
		System.out.println("insert��û��.");
		System.out.println(bag);
		System.out.println(dao);
		
		//dao���� insert��û!!
		dao.insert(bag);
	}
	
	@RequestMapping("update2.multi")
	public void update(BbsVO bag) {
		System.out.println("update��û��.");
		System.out.println(bag);
		System.out.println(dao);
		
		//dao���� insert��û!!
		dao.update(bag);
	}
	
	@RequestMapping("delete2.multi")
	public void delete(int no) {
		System.out.println("delete��û��.");
		System.out.println(no);
		System.out.println(dao);
		
		//dao���� insert��û!!
		dao.delete(no);
	}
//	@RequestMapping("update")
//	public void update(BbsVO bag) {
//		System.out.println("update��û��.");
//		System.out.println(bag);	
//		dao.update(bag);
//	}
//	
//	@RequestMapping("delete")
//	public void delete(int no) {
//		System.out.println("delete��û��.");
//		System.out.println(no);
//		dao.delete(no);
//	}
//	
//	@RequestMapping("one6")
//	public void one6(int no, Model model) {
//		System.out.println("one��û��.");
//		System.out.println(no);
//		//BbsVO bag = dao.one(no);
//		//�˻������ �ִ��� ����Ʈ!
//		//System.out.println(bag);
//		//model.addAttribute("bag", bag);
//	}
//	
//	@RequestMapping("list5")
//	public void list(Model model) {
//		//ArrayList<BbsVO> list = dao.list();
//		//System.out.println(list.size()); //����� ������.
//		//model.addAttribute("list", list);
//	}
	
	//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%8F%99%EC%B0%A8	
}