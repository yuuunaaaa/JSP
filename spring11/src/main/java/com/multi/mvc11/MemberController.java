package com.multi.mvc11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class MemberController {
	
	@Autowired
	MemberDAO dao; 
	
	@RequestMapping("insert")
	public void insert(MemberVO bag) {
		System.out.println(bag);
		dao.insert(bag);
	}
}