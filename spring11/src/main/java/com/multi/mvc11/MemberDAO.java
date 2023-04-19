package com.multi.mvc11;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO { 
	
	@Autowired
	SqlSessionTemplate my;
	
	public void insert(MemberVO bag) {
		my.insert("member.create", bag);
	}
}