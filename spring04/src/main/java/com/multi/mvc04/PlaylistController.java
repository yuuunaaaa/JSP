package com.multi.mvc04;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���������� �����ϴ� ���ҷ� ���! 
public class PlaylistController {
	@Autowired
	PlaylistDAO dao;

	@RequestMapping("insert5.multi")
	public void insert(PlaylistVO bag) {
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
	
	@RequestMapping("update5.multi")
	public void update(PlaylistVO bag) {
		System.out.println("update��û��.");
		System.out.println(bag);	
		dao.update(bag);
	}
	
	@RequestMapping("delete5.multi")
	public void delete(String id) {
		System.out.println("delete��û��.");
		System.out.println(id);
		dao.delete(id);
	}
	
	@RequestMapping("one5.multi")
	public void one(String id, Model model) {
		System.out.println("one��û��.");
		PlaylistVO bag = dao.one(id);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("list5")
	public void list(Model model) {
		ArrayList<PlaylistVO> list = dao.list();
		System.out.println("������ : " + list.size());
		model.addAttribute("list", list);
	}
	
	//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%8F%99%EC%B0%A8
}