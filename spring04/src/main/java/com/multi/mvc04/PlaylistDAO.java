package com.multi.mvc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;

//import ?��면DB?���?.PlaylistVO;
@Component
public class PlaylistDAO { // CRUD
	
	public ArrayList<PlaylistVO> list() {
		ResultSet rs = null; // ?��목명 + 결과 ?��?��?���? ?���? ?��?�� ?��?���?

		// �?방들 ?��?���? ?�� 컨테?��?�� ?��?��?�� �??��?�� ?��?��!
		// ArrayList<PlaylistVO> ==> PlaylistVO�? ?��?���? arraylist?��?�� ?���?
		ArrayList<PlaylistVO> list = new ArrayList<PlaylistVO>();

		PlaylistVO bag = null;
		try {
			// 1.?��?��?�� 11g?? ?��결한 �??�� ?��?��
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL�? ?���? ?��결할 �??�� ?��?�� ?���?.");
			Locale.setDefault(Locale.US); // �? locale?��?��?��?�� 분들�?!!!

			// 2.?��?��?�� 11g?�� ?��결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?��름입?��"); //String, ?��?��무개
			System.out.println("2. mySQL ?���? ?���?.");
			// 컨트�? + ?��?��?�� + f : 코드 ?��?�� ?���?!

			String sql = "select * from playlist";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// ?��?��!!!! ps.setString(1, id);
			System.out.println("3. SQL�? �??��(객체)?���? 만들?��주기 ?���?.");

			rs = ps.executeQuery(); // select�? ?��?��?��
			System.out.println("4. SQL�? ?��?��?���? 보내�? ?���?.");
			while (rs.next()) { // �??��결과�? ?��?���? ?���??�� rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
				
				// 3. 컨테?��?��?�� �?�? ?���?(row?�� 개수)
				list.add(bag);
			}
			// System.out.println(result);
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel?? XXXXX!
		// return ?��?��?�� 반드?�� ?��?�� ?��?��?���? 묶어?�� 리턴?��주어?�� ?��.
		// �??��결과�? ?��?�� ?��?�� bag?�� ?��?��?���? ?��?��?��?��.
		// �??��결과�? ?��?�� ?��?�� bag?�� 무엇?�� ?��?��?��?��? null
		return list;

	}
	
	public PlaylistVO one(String id) {
		// �??�� 결과�? null?�� ?�� 경우 ?��?���? id 출력
		System.out.println(id);
		ResultSet rs = null; // ?��목명 + 결과 ?��?��?���? ?���? ?��?�� ?��?���?
		// 기본?�� ?��?��/?��?��/문자/?��리만 값으�? 초기?��
		// ?��머�? ?��?��?��?��(참조?��) 주소�?! ?��?���? ?��?��.
		// 참조?�� �??���? 초기?��?�� ?��?�� null(주소�? ?��?��?��?�� ?���?)
		PlaylistVO bag = null;
		try {
			// 1.?��?��?�� 11g?? ?��결한 �??�� ?��?��
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL�? ?���? ?��결할 �??�� ?��?�� ?���?.");
			Locale.setDefault(Locale.US); // �? locale?��?��?��?�� 분들�?!!!

			// 2.?��?��?�� 11g?�� ?��결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?��름입?��"); //String, ?��?��무개
			System.out.println("2. mySQL ?���? ?���?.");
			
			String sql = "select * from playlist where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL�? �??��(객체)?���? 만들?��주기 ?���?.");

			rs = ps.executeQuery(); // select�? ?��?��?��
			System.out.println("4. SQL�? ?��?��?���? 보내�? ?���?.");
			if (rs.next()) { // �??��결과�? ?��?���? ?���??�� rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
				
			} else {
				System.out.println("�??��결과 ?��?��. ?���?.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel?? XXXXX!
		// return ?��?��?�� 반드?�� ?��?�� ?��?��?���? 묶어?�� 리턴?��주어?�� ?��.
		// �??��결과�? ?��?�� ?��?�� bag?�� ?��?��?���? ?��?��?��?��.
		// �??��결과�? ?��?�� ?��?�� bag?�� 무엇?�� ?��?��?��?��? null
		return bag;

	}
	
	public ArrayList<PlaylistVO> one55(String title) {
		System.out.println(title);
		ResultSet rs = null; // ?��목명 + 결과 ?��?��?���? ?���? ?��?�� ?��?���?

		// �?방들 ?��?���? ?�� 컨테?��?�� ?��?��?�� �??��?�� ?��?��!
		// ArrayList<MovieVO> ==> MovieVO�? ?��?���? arraylist?��?�� ?���?
		ArrayList<PlaylistVO> list = new ArrayList<PlaylistVO>();

		PlaylistVO bag = null;
		try {
			// 1.?��?��?�� 11g?? ?��결한 �??�� ?��?��
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL�? ?���? ?��결할 �??�� ?��?�� ?���?.");
			Locale.setDefault(Locale.US); // �? locale?��?��?��?�� 분들�?!!!

			// 2.?��?��?�� 11g?�� ?��결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?��름입?��"); //String, ?��?��무개
			System.out.println("2. mySQL ?���? ?���?.");
			// 컨트�? + ?��?��?�� + f : 코드 ?��?�� ?���?!

			String sql = "select id, title, artist from playlist where title like ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, "%" + title + "%");
			System.out.println("3. SQL�? �??��(객체)?���? 만들?��주기 ?���?.");

			rs = ps.executeQuery(); // select�? ?��?��?��
			System.out.println("4. SQL�? ?��?��?���? 보내�? ?���?.");
			while (rs.next()) { // �??��결과�? ?��?���? ?���??�� rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				// 4. list?�� bag?�� 추�??��주자.
				list.add(bag);
			}
			// System.out.println(result);
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int delete(String id) {
	int result = 0;

	try {
		// 1.?��?��?�� 11g?? ?��결한 �??�� ?��?��
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQL�? ?���? ?��결할 �??�� ?��?�� ?���?.");

		// 2.?��?��?�� 11g?�� ?��결해보자.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		
		System.out.println("2. mySQL ?���? ?���?.");

		String sql = "delete from playlist where id = ? ";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		ps.setString(1, id);
		System.out.println("3. SQL�? �??��(객체)?���? 만들?��주기 ?���?.");

		result = ps.executeUpdate();
		System.out.println("4. SQL�? ?��?��?���? 보내�? ?���?.");
		if (result == 1) {
			System.out.println("?��?�� ?���?.");
		}
		// System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return result;

}

// 1. �?방을 받아?�� ???��?��?��?��.
// 2. ?��?��?�� ?�� �?방에?�� 값들?�� ?��?��?�� 꺼내?��.
public int update(PlaylistVO bag) {
	int result = 0;
	try {
		// 1.?��?��?�� 11g?? ?��결한 �??�� ?��?��
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQL�? ?���? ?��결할 �??�� ?��?�� ?���?.");
		Locale.setDefault(Locale.US); // �? locale?��?��?��?�� 분들�?!!!

		// 2.?��?��?�� 11g?�� ?��결해보자.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		// String data = JOptionPane.showInputDialog("?��름입?��"); //String, ?��?��무개
		System.out.println("2. mySQL ?���? ?���?.");

		// ipaddress ==> InetAddress
		// String url = "http://wwww.naver.com";
		// URL u = new URL(url);
		// ?��바는 �??��조립?��?��?��?��,String?�� ?��?? 문자?��?�� ?��?��?�� �??��?���? ?��?��?���? 못함.
		// ?��?��?�� �??��?���? ?��?��?��?���? �? �??��?���? 만들?��주어?�� ?��?��.
		// SQL�??��?���? 만들?��주어?�� ?��.
		// PreparedStatement�? SQL�??��!!

		String sql = "update playlist set title = ? where id = ? ";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		ps.setString(1, bag.getTitle());
		ps.setString(2, bag.getId());
		System.out.println("3. SQL�? �??��(객체)?���? 만들?��주기 ?���?.");

		result = ps.executeUpdate(); // 1
		// insert, update, delete문만!! sql�? ?��?��결과�? int
		System.out.println("4. SQL�? ?��?��?���? 보내�? ?���?.");
		if (result == 1) {
			System.out.println("?��?�� ?���?.");
		}
		// System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}

// public void add2() {
public int insert(PlaylistVO bag) {
	// 1. �?방을 받아?�� �??��?�� ?��?��주세?��.
	int result = 0;

	try {
		// 1.?��?��?�� 11g?? ?��결한 �??�� ?��?��
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQL�? ?���? ?��결할 �??�� ?��?�� ?���?.");
		Locale.setDefault(Locale.US); // �? locale?��?��?��?�� 분들�?!!!

		// 2.?��?��?�� 11g?�� ?��결해보자.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		// String data = JOptionPane.showInputDialog("?��름입?��"); //String, ?��?��무개
		System.out.println("2. mySQL ?���? ?���?.");

		String sql = "insert into playlist values (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		// con�??��?���? sql?��?��링에 ?��?�� �? SQL�??��?���? 만들?��주세?��.
		// R빼고, ?��?��?�� 0�??�� ?��?��!!
		// ?��?��?���? db?? ?��?��?���? 1�??�� ?��?��!!
		// 2. �?방에?�� 값들?�� ?��?��?�� 꺼내?��?��?��.
		ps.setString(1, bag.getId()); // ps.setInt(1, no);
		ps.setString(2, bag.getTitle());
		ps.setString(3, bag.getArtist());
		ps.setString(4, bag.getGenre());
		ps.setString(5, bag.getImg());

		// ==> insert into hr.MEMBER values ('a','a','a','a');
		System.out.println("3. SQL�? �??��(객체)?���? 만들?��주기 ?���?.");

		result = ps.executeUpdate(); // 1
		System.out.println("4. SQL�? ?��?��?���? 보내�? ?���?.");
		if (result == 1) {
			System.out.println("?��?���??�� ?���?!");
		}
		// System.out.println(result);
	} catch (Exception e) {
		// insert�? ?��??�? ?��?�� 경우, ?��?��?�� ?��?��?��?���? ?��?��?���?
		// catch�? ?��?��
		// ?��?��?�� Row?���? ?��?���?�? Result?�� 0?�� ?��?��주자.!
		// result = 0;
		e.printStackTrace();
	}

	System.out.println(result);
	return result;
}
}