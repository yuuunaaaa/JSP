package com.multi.mvc10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	@Autowired
	BookDAO dao;//100
	
	@RequestMapping("insert3.multi")
	public void insert(BookVO bag) {
		
		System.out.println("insert��û��.");
		System.out.println(bag);
		System.out.println(dao);
		dao.insert(bag);
	}
	
	@RequestMapping("update3.multi")
	public void update(BookVO bag) {
		
		System.out.println("update��û��.");
		System.out.println(bag);
		System.out.println(dao);
		dao.update(bag);
	}
	
	@RequestMapping("delete3.multi")
	public void delete(int id) {
		
		System.out.println("delete��û��.");
		System.out.println(id);
		System.out.println(dao);
		dao.delete(id);
	}
	
	@RequestMapping("one3.multi")
	public void one(int id, Model model) {
		
		System.out.println("one��û��.");
		System.out.println(id);
		BookVO bag = dao.one(id);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("list3")
	public void list(Model model) {
		List<BookVO> list = dao.list();
		model.addAttribute("list", list);
	}
}
