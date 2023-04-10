package com.multi.mvc10;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookDAO {
	
	@Autowired
	SqlSessionTemplate my;
	
	public int insert(BookVO bag) {
		System.out.println("------" + my);
		int result = my.insert("book.insert", bag);
		return result;
	}
	
	public int update(BookVO bag) {
		System.out.println("------" + my);
		int result = my.update("book.update", bag);
		return result;
	}
	
	public int delete(int id) {
		System.out.println("------" + my);
		int result = my.delete("book.delete", id);
		return result;
	}
	
	public BookVO one(int id) {
		BookVO bag = my.selectOne("book.one", id);
		return bag;
	}
	
	public List<BookVO> list() {
		List<BookVO> list = my.selectList("book.all");
		return list;
	}
}