package com.multi.mvc07;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���������� �����ϴ� ���ҷ� ���! 
public class BbsController {

	@Autowired
	BbsDAO dao;
	
	@Autowired
	ReplyDAO dao2;

	@RequestMapping("insert2.multi")
	public void insert(BbsVO bag, BbsDAO dao) {
		//�޼����� �Էº���(�Ķ����)�� ������
		//�����صθ�, ��Ʈ�ѷ����� �޼��峻������
		//1)bag�� ���� 
		//2)Ŭ���̾�Ʈ�� ���� ���޵� �����͵� �޾���.
		//3)bag�� ������ �� �־���.
		System.out.println("insert��û��.");
		System.out.println(bag);
		
		//dao���� insert��û!!
		dao.insert(bag);
	}
	
	@RequestMapping(value = {"update2.multi", "update5"})
	public void update(BbsVO bag, BbsDAO dao) {
		System.out.println("update��û��.");
		System.out.println(bag);	
		dao.update(bag);
	}
	
	@RequestMapping(value = {"delete2.multi", "delete5"})
	public void delete(int no, BbsDAO dao) {
		System.out.println("delete��û��.");
		System.out.println(no);
		dao.delete(no);
	}
	
	@RequestMapping("one2.multi")
	public void one(int no, Model model) {
		System.out.println("one��û��.");
		System.out.println(no);
		BbsVO bag = dao.one(no);
		//�˻������ �ִ��� ����Ʈ!
		System.out.println(bag);
		ArrayList<ReplyVO> list = dao2.list(no);
		model.addAttribute("list", list);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("one6")
	public void one6(int no, Model model) {
		System.out.println("one��û��.");
		System.out.println(no);
		BbsVO bag = dao.one(no);
		//�˻������ �ִ��� ����Ʈ!
		System.out.println(bag);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("list5")
	public void list(Model model) {
		ArrayList<BbsVO> list = dao.list();
		System.out.println(list.size()); //����� ������.
		model.addAttribute("list", list);
	}
	
	//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%8F%99%EC%B0%A8	
}