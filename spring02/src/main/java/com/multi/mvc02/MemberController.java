package com.multi.mvc02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���������� �����ϴ� ���ҷ� ���! 
public class MemberController {
	
	@Autowired
	MemberDAO dao; //��������(�۷ι� ����) 

	//��Ʈ�� �ϴ� ���(CRUD)
	//ȸ������, ����, Ż��, �����˻�
	
	//Ŭ���� ������ ���ó�� ���
	//������� + ����޼���(���ó�� ���)
	//�ϳ��� ��û�� �ϳ��� �޼���
	//�ϳ��� ��ưȣ��� �ϳ��� �Լ� ����!
	//��û�� �ּҰ� ��� �� ��
	//�ٷ� �Ʒ��� �ִ� �޼��尡 ȣ���� ������
	//���־�� �Ѵ�. 
	@RequestMapping("insert")
	public void insert(MemberVO bag) {
		//�޼����� �Էº���(�Ķ����)�� ������
		//�����صθ�, ��Ʈ�ѷ����� �޼��峻������
		//1)bag�� ���� 
		//2)Ŭ���̾�Ʈ�� ���� ���޵� �����͵� �޾���.
		//3)bag�� ������ �� �־���.
		System.out.println("insert��û��.");
		System.out.println(bag);
		System.out.println(dao);
		//MemberDAO dao - new MemberDAO();
		//dao���� insert ��û!!
		dao.insert(bag);
	}
	
	@RequestMapping("update")
	public void update(MemberVO bag) {
		System.out.println("update��û��.");
		System.out.println(bag);
		dao.update(bag);
	}
	
	@RequestMapping("delete")
	public void delete(String id) {
		System.out.println("delete��û��.");
		System.out.println(id);
		dao.delete(id);
	}
	
	@RequestMapping("one")
	public void one(MemberVO bag) {
		System.out.println("one��û��.");
		System.out.println(bag);
	}
	
	@RequestMapping("list")
	public void list() {
		
	}
	
	//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%8F%99%EC%B0%A8

}