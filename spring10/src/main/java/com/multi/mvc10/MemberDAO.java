package com.multi.mvc10;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import ȭ��DB����.MemberVO;
//�������� dao�� �̱������� �ϳ��� ���� ����Ұ�!��� �����ؾ���.
//2���� ����� ����
// ������̼�(ǥ��) ���, XML ���
@Component
public class MemberDAO { // CRUD
	@Autowired
	SqlSessionTemplate my;

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
	
	public MemberVO one(String id) {
		MemberVO bag = my.selectOne("member.one", id);
		return bag;
	}
}
