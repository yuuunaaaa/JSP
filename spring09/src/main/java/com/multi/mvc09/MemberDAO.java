package com.multi.mvc09;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import 화면DB연결.MemberVO;
//스프링에 dao는 싱글톤으로 하나만 만들어서 사용할게!라고 설정해야함.
//2가지 방법이 있음
// 어노테이션(표시) 방법, XML 방법
@Component
public class MemberDAO { // CRUD
	@Autowired
	SqlSessionTemplate my;
//	public int login(MemberVO bag) {
//		int result = 0; // 항목명이랑 결과를 담고 있는 테이블이다.
//		
//		return result;
//	}
//	
//	public ArrayList<MemberVO> list() {
//		
//		return list;
//
//	}
//
//	public MemberVO one(String id) {
//		
//		return bag;
//
//	}
//
	public int delete(String id) {
		int result = my.delete("member.del", id);
		return result;
	}

	public int update(MemberVO bag) {
		int result = my.update("member.up", bag);		
		return result;
	}

	public int insert(MemberVO bag) {
		int result = my.insert("member.create", bag);
								// namespace.id
		return result;
	}
}
