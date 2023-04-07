package com.multi.mvc09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���������� �����ϴ� ���ҷ� ���! dependency
public class FoodController {
	
	@Autowired
	//MemberDAO�� �̱��� ��ü ram�� ��� �ִ��� ã�Ƽ� 
	//�� �ּҸ� �Ʒ� ������ �־��ּ���.
	FoodDAO dao; //��������(�۷ι� ����) 
	
	@RequestMapping("insert4.multi")
	public void insert(FoodVO bag) {
		
		System.out.println("insert��û��.");
		System.out.println(bag);
		System.out.println(dao);
		dao.insert(bag);
	}
	@RequestMapping("update4")
	public void update(FoodVO bag) {
		System.out.println("update��û��.");
		System.out.println(bag);
		dao.update(bag);
	}
	
	@RequestMapping("delete4")
	public void delete(String id) {
		System.out.println("delete��û��.");
		System.out.println(id);
		dao.delete(id);
	}
	
	@RequestMapping("one4")
	public void one(String id, Model model) {
		System.out.println("one��û��.");
		System.out.println(id);
		FoodVO bag = dao.one(id);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("list4")
	public void list(Model model) {
		//Model�� ��Ʈ�ѷ��� list�� views/list.jsp������ ������ �� �ִ� ��ü 
		//ArrayList<MemberVO> list = dao.list();
		//model.addAttribute("list", list);
	} 
}
