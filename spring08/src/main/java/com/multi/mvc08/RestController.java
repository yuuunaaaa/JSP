package com.multi.mvc08;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	
	@RequestMapping("json1")
	@ResponseBody // ��û ������ return�Ǵ� �����͸� json���� ���� ��û�ϴ� ������ �ٽ� ����.
	public MemberVO json1() {
		MemberVO bag = new MemberVO();
		bag.setId("root");
		bag.setPw("1234");
		bag.setName("hong");
		bag.setTel("011");
		return bag;
	}
	
	@RequestMapping("json2")
	@ResponseBody // ��û ������ return�Ǵ� �����͸� json���� ���� ��û�ϴ� ������ �ٽ� ����.
	public ArrayList<MemberVO> json2() {
		MemberVO bag = new MemberVO();
		bag.setId("root");
		bag.setPw("1234");
		bag.setName("hong");
		bag.setTel("011");
		
		MemberVO bag2 = new MemberVO();
		bag2.setId("root2");
		bag2.setPw("12342");
		bag2.setName("hong2");
		bag2.setTel("0112");
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list.add(bag);
		list.add(bag2);
		
		return list;
	}
	
	@RequestMapping("json3")
	@ResponseBody // ��û ������ return�Ǵ� �����͸� json���� ���� ��û�ϴ� ������ �ٽ� ����.
	public BbsVO json3() {
		BbsVO bag = new BbsVO();
		bag.setNo(19);
		bag.setTitle("ȫ");
		bag.setContent("ȫȣȫ");
		bag.setWriter("hong");
		
		return bag;
	}
	
	@RequestMapping("json4")
	@ResponseBody // ��û ������ return�Ǵ� �����͸� json���� ���� ��û�ϴ� ������ �ٽ� ����.
	public ArrayList<BbsVO> json4() {
		BbsVO bag = new BbsVO();
		bag.setNo(19);
		bag.setTitle("ȫ");
		bag.setContent("ȫȣȫ");
		bag.setWriter("hong");
		
		BbsVO bag2 = new BbsVO();
		bag2.setNo(20);
		bag2.setTitle("���");
		bag2.setContent("����մϴ�");
		bag2.setWriter("apple");
		
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		list.add(bag);
		list.add(bag2);
		
		return list;
	}
	

	@RequestMapping("jsonResponse3")
	@ResponseBody // ��û ������ return�Ǵ� �����͸� json���� ���� ��û�ϴ� ������ �ٽ� ����.
	public MemberVO jsonResponse3() {
		MemberVO bag = new MemberVO();
		bag.setId("root");
		bag.setPw("1234");
		bag.setName("hong");
		bag.setTel("011");
		return bag;
	}
	
	@RequestMapping("jsonResponse4")
	@ResponseBody // ��û ������ return�Ǵ� �����͸� json���� ���� ��û�ϴ� ������ �ٽ� ����.
	public ArrayList<MemberVO> jsonResponse4() {
		MemberVO bag = new MemberVO();
		bag.setId("root");
		bag.setPw("1234");
		bag.setName("hong");
		bag.setTel("011");
		
		MemberVO bag2 = new MemberVO();
		bag2.setId("root2");
		bag2.setPw("12342");
		bag2.setName("hong2");
		bag2.setTel("0112");
		
		MemberVO bag3 = new MemberVO();
		bag3.setId("root3");
		bag3.setPw("12343");
		bag3.setName("hong3");
		bag3.setTel("0113");
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list.add(bag);
		list.add(bag2);
		list.add(bag3);
		
		return list;
	}
	
	@RequestMapping("jsonResponse5")
	@ResponseBody // ��û ������ return�Ǵ� �����͸� json���� ���� ��û�ϴ� ������ �ٽ� ����.
	public MapVO jsonResponse5() {
		MapVO bag = new MapVO();
		bag.setName("�ڿ���");
		bag.setLatitude(37.5116828);
		bag.setLongitude(127.059151);
		System.out.println(bag);
		return bag;
	}
	
	@RequestMapping("jsonResponse6")
	@ResponseBody // ��û ������ return�Ǵ� �����͸� json���� ���� ��û�ϴ� ������ �ٽ� ����.
	public ChartVO jsonResponse6() {
		ChartVO bag = new ChartVO();
		bag.setCoding(11);
		bag.setEat(2);
		bag.setRest(4);
		bag.setSleep(7);
		System.out.println(bag);
		return bag;
	}
}