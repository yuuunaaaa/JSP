package com.multi.mvc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

@Component
public class BookDAO {
	
	public void insert(BookDTO bag) {

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

			String sql = "insert into book(name, url, img) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, bag.getName());
			ps.setString(2, bag.getUrl());
			ps.setString(3, bag.getImg());
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			ps.executeUpdate();
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
