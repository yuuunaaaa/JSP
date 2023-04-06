package com.multi.mvc08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;

//import ȭ��DB����.MemberVO;
//�������� dao�� �̱������� �ϳ��� ���� ����Ұ�!��� �����ؾ���.
//2���� ����� ����
// ������̼�(ǥ��) ���, XML ���
@Component
public class MemberDAO { // CRUD
	public int login(MemberVO bag) {
		int result = 0; // �׸���̶� ����� ��� �ִ� ���̺��̴�.
		try {
			// 1. ����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL�� �ڹ� ������ ��ǰ ���� ����.");
			// 2. ����Ŭ 11g�� �����غ���. JAVA ------ Oracle
			// String url = "jdbc:mysql://localhost:3306:multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL ���� ����.");
			String sql = "select * from member where id=? and pw=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ�.");
			ResultSet rs = ps.executeQuery();
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if (rs.next()) { // �˻������ ������ TRUE ������ false
				System.out.println("�˻���� ���� ����!");
				result = 1;
			}
			System.out.println("�˻� ��� ����.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<MemberVO> list() {
		ResultSet rs = null; // �׸�� + ��� �����͸� ��� �ִ� ���̺�

		// ����� �־��� ū �����̳� ������ ��ǰ�� �ʿ�!
		// ArrayList<MemberVO> ==> MemberVO�� �� arraylist��� �ǹ�
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		MemberVO bag = null;
		try {
			// 1.����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL�� �ڹ� ������ ��ǰ ���� ����.");

			// 2.����Ŭ 11g�� �����غ���.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("�̸��Է�"); //String, �Ӿƹ���
			System.out.println("2. mySQL ���� ����.");
			// ��Ʈ�� + ����Ʈ + f : �ڵ� �ڵ� ����!

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// �ڹٴ� ��ǰ�������̿���,String�� ���� ���ڿ��� Ư���� ��ǰ���� �ν����� ����.
			// Ư���� ��ǰ���� �ν��Ϸ��� �� ��ǰ���� ������־�� �Ѵ�.
			// SQL��ǰ���� ������־�� ��.
			// PreparedStatement�� SQL��ǰ!!

			String sql = "select * from member";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// ����!!!! ps.setString(1, id);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			rs = ps.executeQuery(); // select�� ���۽�
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			while (rs.next()) { // �˻������ �ִ��� ���δ� rs.next()
				// true�̸� �ִٶ�� �ǹ�, false�̸� ���ٶ�� �ǹ�
				// 1. �˻��ܷΰ��� ������,
				// System.out.println("�˻���� ����. ����.");
				// 2. �� �÷����� ������ ��������.
				String id2 = rs.getString(1); // id
				String pw = rs.getString(2); // pw
				String name = rs.getString(3); // name
				String tel = rs.getString(4); // tel
				// System.out.println( id2 + " "
//									+ pw + " " 
//									+ name + " " 
//									+ tel);
				// �˻������ �˻�ȭ�� UI�κ��� �־�� ��.
				// 3. ������ ������.
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);

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

	// �޼��带 ����� �� ==> �޼��� ����(define)!
	// �޼��带 �����ߴٰ� ����Ǵ� ���� �ƴϴ�.!
	// �޼��带 ���� �� ==> �޼��� ȣ��(call)!
	public MemberVO one(String id) {
		ResultSet rs = null; // �׸�� + ��� �����͸� ��� �ִ� ���̺�
		// �⺻�� ����/�Ǽ�/����/���� ������ �ʱ�ȭ
		// ������ ��������(������) �ּҰ�! �� ����.
		// ������ ������ �ʱ�ȭ�� ���� null(�ּҰ� ���ٶ�� �ǹ�)
		MemberVO bag = null;
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

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// �ڹٴ� ��ǰ�������̿���,String�� ���� ���ڿ��� Ư���� ��ǰ���� �ν����� ����.
			// Ư���� ��ǰ���� �ν��Ϸ��� �� ��ǰ���� ������־�� �Ѵ�.
			// SQL��ǰ���� ������־�� ��.
			// PreparedStatement�� SQL��ǰ!!

			String sql = "select * from member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			rs = ps.executeQuery(); // select�� ���۽�
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if (rs.next()) { // �˻������ �ִ��� ���δ� rs.next()
				// true�̸� �ִٶ�� �ǹ�, false�̸� ���ٶ�� �ǹ�
				System.out.println("�˻���� ����. ����.");
				String id2 = rs.getString(1); // id
				String pw = rs.getString("pw"); // pw
				String name = rs.getString(3); // name
				String tel = rs.getString(4); // tel
				System.out.println(id2 + " " + pw + " " + name + " " + tel);
				// �˻������ �˻�ȭ�� UI�κ��� �־�� ��.
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
			} else {
				System.out.println("�˻���� ����. ����.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel�� XXXXX!
		// return �ڿ��� �ݵ�� ���� �����͸� ��� �������־�� ��.
		// �˻������ ���� ���� bag�� �����Ͱ� �������.
		// �˻������ ���� ���� bag�� ������ ����ֳ�? null
		return bag;

	}

	public int delete(String id) {
		int result = 0;

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

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// �ڹٴ� ��ǰ�������̿���,String�� ���� ���ڿ��� Ư���� ��ǰ���� �ν����� ����.
			// Ư���� ��ǰ���� �ν��Ϸ��� �� ��ǰ���� ������־�� �Ѵ�.
			// SQL��ǰ���� ������־�� ��.
			// PreparedStatement�� SQL��ǰ!!

			String sql = "delete from member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			result = ps.executeUpdate();
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if (result == 1) {
				System.out.println("Ż�� ����.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	// 1. ������ �޾Ƽ� �����ص���.
	// 2. �ʿ��� �� ���濡�� ������ �ϳ��� ������.
	public int update(MemberVO bag) {
		int result = 0;
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

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// �ڹٴ� ��ǰ�������̿���,String�� ���� ���ڿ��� Ư���� ��ǰ���� �ν����� ����.
			// Ư���� ��ǰ���� �ν��Ϸ��� �� ��ǰ���� ������־�� �Ѵ�.
			// SQL��ǰ���� ������־�� ��.
			// PreparedStatement�� SQL��ǰ!!

			String sql = "update member set tel = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			result = ps.executeUpdate(); // 1
			// insert, update, delete����!! sql�� �������� int
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if (result == 1) {
				System.out.println("���� ����.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// public void add2() {
	public int insert(MemberVO bag) {
		// 1. ������ �޾Ƽ� ������ �־��ּ���.
		int result = 0;

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

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// �ڹٴ� ��ǰ�������̿���,String�� ���� ���ڿ��� Ư���� ��ǰ���� �ν����� ����.
			// Ư���� ��ǰ���� �ν��Ϸ��� �� ��ǰ���� ������־�� �Ѵ�.
			// SQL��ǰ���� ������־�� ��.
			// PreparedStatement�� SQL��ǰ!!

			// public void insert(String id, String pw, String name, String tel)
			String sql = "insert into member values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// con��ǰ���� sql��Ʈ���� �ִ� �� SQL��ǰ���� ������ּ���.
			// R����, �ε��� 0���� ����!!
			// �����ϰ� db�� �ε����� 1���� ����!!
			// 2. ���濡�� ������ �ϳ��� ����������.
			ps.setString(1, bag.getId()); // ps.setInt(1, no);
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());

			// ==> insert into hr.MEMBER values ('a','a','a','a');
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			result = ps.executeUpdate(); // 1
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if (result == 1) {
				System.out.println("ȸ������ ����!");
			}
			// System.out.println(result);
		} catch (Exception e) {
			// insert�� ����� �ȵ� ���, ������ ��Ȳ�̶�� �Ǵ��ϰ�
			// catch�� ����
			// ����� Row���� �����Ƿ� Result�� 0�� �־�����.!
			// result = 0;
			e.printStackTrace();
		}

		System.out.println(result);
		return result;
	}
}
