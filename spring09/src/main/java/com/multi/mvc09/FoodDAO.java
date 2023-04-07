package com.multi.mvc09;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import 화면DB연결.MemberVO;
//스프링에 dao는 싱글톤으로 하나만 만들어서 사용할게!라고 설정해야함.
//2가지 방법이 있음
// 어노테이션(표시) 방법, XML 방법
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
