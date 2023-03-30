package com.multi.mvc04;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;

//import ȭ��DB����.BookDTO;
//import ȭ��DB����.BookDTO;
//import java.sql.PreparedStatement;
//���̺� �ϳ��� DAO �ϳ�! ==>
@Component
public class BookDAO {
	public ArrayList<BookDTO> list() {
		ResultSet rs = null; // �׸�� + ��� �����͸� ��� �ִ� ���̺�

		// ����� �־��� ū �����̳� ������ ��ǰ�� �ʿ�!
		// ArrayList<MemberVO> ==> MemberVO�� �� arraylist��� �ǹ�
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();

		BookDTO bag = null;
		try {
			// 1.����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL�� �ڹ� ������ ��ǰ ���� ����.");
			Locale.setDefault(Locale.US); // �� locale�������� �е鸸!!!

			// 2.����Ŭ 11g�� �����غ���.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("�̸��Է�"); //String, �Ӿƹ���
			System.out.println("2. mySQL ���� ����.");
			// ��Ʈ�� + ����Ʈ + f : �ڵ� �ڵ� ����!

			String sql = "select * from book";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// ����!!!! ps.setString(1, id);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			rs = ps.executeQuery(); // select�� ���۽�
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			while (rs.next()) { // �˻������ �ִ��� ���δ� rs.next()
				// true�̸� �ִٶ�� �ǹ�, false�̸� ���ٶ�� �ǹ�
				// 1. �˻������ ������,
				// System.out.println("�˻���� ����. ����.");
				int id = rs.getInt(1);
				String name = rs.getString(2); 
				String url2 = rs.getString(3); 
				String img = rs.getString(4); 
				// �˻������ �˻�ȭ�� UI�κ��� �־�� ��.
				bag = new BookDTO();
				bag.setId(id);
				bag.setName(name);
				bag.setUrl(url2);
				bag.setImg(img);

				// 4. list�� bag�� �߰�������.
				list.add(bag);
			}
			// System.out.println(result);
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel�� XXXXX!
		// return �ڿ��� �ݵ�� ���� �����͸� ��� �������־�� ��.
		// �˻������ ���� ���� bag�� �����Ͱ� �������.
		// �˻������ ���� ���� bag�� ������ ����ֳ�? null
		return list;

	}
	
	public void insert(BookDTO bag) {
		try {
			// 1.����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL�� �ڹ� ������ ��ǰ ���� ����");

			// 2.����Ŭ 11g�� �����غ���.(java ---oracle)
			// String url = "jdbc:mysql://localhost:3306:multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL ���� ����");

			// ipdaaress ==> InetAddress
			// String url = "http://www.naver.com";
			// URL u = new URL(url);
			// �ڹٴ� ��ǰ�������̿���, String�� ���� ���ڿ��� Ư���� ��ǰ���� �ν����� ����.
			// Ư���� ��ǰ���� �ν��Ϸ��� �� ��ǰ���� ������־�� �Ѵ�.
			// SQL��ǰ���� ������־�� ��.
			// PreparedStatement�� SQL��ǰ !!

			String sql = "insert into book (name, url, img) values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// con ��ǰ���� sql��Ʈ���� �ִ� �� SQL��ǰ���� ������ּ���.
			// R����, �ε���0���� ����!!
			// �����ϰ� db�� �ε����� 1���� ����!!
			ps.setString(1, bag.getName());
			ps.setString(2, bag.getUrl());
			ps.setString(3, bag.getImg());
			// ==> insert into hr.MEMBER values('a', 'a' ,'a', 'a');
			System.out.println("3.SQL�� ��ǰ(��ü)���� ������ֱ�");

			ps.executeUpdate();
			System.out.println("4.SQL�� ����Ŭ�� ������ ����.");
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BookDTO one(String id) {
		ResultSet rs = null; // �׸�� + ��� �����͸� ��� �ִ� ���̺�
		BookDTO bag = null;
		try {
			// 1.����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL�� �ڹ� ������ ��ǰ ���� ����.");
			Locale.setDefault(Locale.US); // �� locale�������� �е鸸!!!

			// 2.����Ŭ 11g�� �����غ���.(java --- oracle)
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL ���� ����.");

			String sql = "select * from book where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			rs = ps.executeQuery(); // select�� ���۽�
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if (rs.next()) { // �˻������ �ִ��� ���δ� rs.next()
				// true�̸� �ִٶ�� �ǹ�, false�̸� ���ٶ�� �ǹ�
				System.out.println("�˻���� ����. ����.");
				int id2 = rs.getInt(1); // id
				String name = rs.getString(2); // name
				String url2 = rs.getString(3); // url2
				String img = rs.getString(4); // img
				// �˻������ �˻�ȭ�� UI�κ��� �־�� ��.
				bag = new BookDTO();
				bag.setId(id2);
				bag.setName(name);
				bag.setUrl(url2);
				bag.setImg(img);
			} else {
				System.out.println("�˻���� ����. ����.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}
}