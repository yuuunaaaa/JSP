package com.multi.mvc02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���������� �����ϴ� ���ҷ� ���! 
public class BbsController {
	@Autowired
	BbsDAO dao;
	//��Ʈ�� �ϴ� ���(CRUD)
	//ȸ������, ����, Ż��, �����˻�
	
	//Ŭ���� ������ ���ó�� ���
	//������� + ����޼���(���ó�� ���)
	//�ϳ��� ��û�� �ϳ��� �޼���
	//�ϳ��� ��ưȣ��� �ϳ��� �Լ� ����!
	//��û�� �ּҰ� ��� �� ��
	//�ٷ� �Ʒ��� �ִ� �޼��尡 ȣ���� ������
	//���־�� �Ѵ�. 
	@RequestMapping("insert2.multi")
	public void insert(BbsVO bag) {
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
	
	@RequestMapping("update2.multi")
	public void update(BbsVO bag) {
		System.out.println("update��û��.");
		System.out.println(bag);	
		dao.update(bag);
	}
	
	@RequestMapping("delete2.multi")
	public void delete(int no) {
		System.out.println("delete��û��.");
		System.out.println(no);
		dao.delete(no);
	}
	
	@RequestMapping("one2.multi")
	public void one(int no) {
		System.out.println("one��û��.");
		System.out.println(no);
	}
	
	@RequestMapping("list2")
	public void list() {
		
	}
	
	//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%8F%99%EC%B0%A8
}