package com.multi.mvc09;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import ȭ��DB����.MemberVO;
//�������� dao�� �̱������� �ϳ��� ���� ����Ұ�!��� �����ؾ���.
//2���� ����� ����
// ������̼�(ǥ��) ���, XML ���
@Component
public class FoodDAO { // CRUD
	@Autowired
	SqlSessionTemplate my;

	public int insert(FoodVO bag) {
		System.out.println("------" + my);
		int result = my.insert("food.insert", bag);
		return result;
	}
	
	public int update(FoodVO bag) {
		System.out.println("------" + my);
		int result = my.update("food.update", bag);
		return result;
	}
	
	public int delete(String id) {
		System.out.println("------" + my);
		int result = my.delete("food.delete", id);
		return result;
	}
	
	public FoodVO one(String id) {
		FoodVO bag = my.selectOne("food.one", id);
		return bag;
	}
	
	public List<FoodVO> list() {
		List<FoodVO> list = my.selectList("food.all");
		return list;
	}
}
