package com.multi.mvc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;

//import ?™”ë©´DB?—°ê²?.PlaylistVO;
@Component
public class PlaylistDAO { // CRUD
	
	public ArrayList<PlaylistVO> list() {
		ResultSet rs = null; // ?•­ëª©ëª… + ê²°ê³¼ ?°?´?„°ë¥? ?‹´ê³? ?ˆ?Š” ?…Œ?´ë¸?

		// ê°?ë°©ë“¤ ?„£?–´ì¤? ?° ì»¨í…Œ?´?„ˆ ?—­?• ?„ ë¶??’ˆ?´ ?•„?š”!
		// ArrayList<PlaylistVO> ==> PlaylistVOë§? ?“¤?–´ê°? arraylist?¼?Š” ?˜ë¯?
		ArrayList<PlaylistVO> list = new ArrayList<PlaylistVO>();

		PlaylistVO bag = null;
		try {
			// 1.?˜¤?¼?´ 11g?? ?—°ê²°í•œ ë¶??’ˆ ?„¤? •
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQLê³? ?ë°? ?—°ê²°í•  ë¶??’ˆ ?„¤? • ?„±ê³?.");
			Locale.setDefault(Locale.US); // ë§? locale?—?Ÿ¬?‚˜?‹  ë¶„ë“¤ë§?!!!

			// 2.?˜¤?¼?´ 11g?— ?—°ê²°í•´ë³´ì.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?´ë¦„ì…? ¥"); //String, ?„?•„ë¬´ê°œ
			System.out.println("2. mySQL ?—°ê²? ?„±ê³?.");
			// ì»¨íŠ¸ë¡? + ?‰¬?”„?Š¸ + f : ì½”ë“œ ??™ ? •ë¦?!

			String sql = "select * from playlist";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// ?‚­? œ!!!! ps.setString(1, id);
			System.out.println("3. SQLë¬? ë¶??’ˆ(ê°ì²´)?œ¼ë¡? ë§Œë“¤?–´ì£¼ê¸° ?„±ê³?.");

			rs = ps.executeQuery(); // selectë¬? ? „?†¡?‹œ
			System.out.println("4. SQLë¬? ?˜¤?¼?´ë¡? ë³´ë‚´ê¸? ?„±ê³?.");
			while (rs.next()) { // ê²??ƒ‰ê²°ê³¼ê°? ?ˆ?Š”ì§? ?—¬ë¶??Š” rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
				
				// 3. ì»¨í…Œ?´?„ˆ?— ê°?ë°? ?„£ê¸?(row?˜ ê°œìˆ˜)
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
		// return ?’¤?—?Š” ë°˜ë“œ?‹œ ?—¬?Ÿ¬ ?°?´?„°ë¥? ë¬¶ì–´?„œ ë¦¬í„´?•´ì£¼ì–´?•¼ ?•¨.
		// ê²??ƒ‰ê²°ê³¼ê°? ?ˆ?„ ?•Œ?Š” bag?— ?°?´?„°ê°? ?“¤?–´?ˆ?Œ.
		// ê²??ƒ‰ê²°ê³¼ê°? ?—†?„ ?•Œ?Š” bag?— ë¬´ì—‡?´ ?“¤?–´?ˆ?‚˜? null
		return list;

	}
	
	public PlaylistVO one(String id) {
		// ê²??ƒ‰ ê²°ê³¼ê°? null?´ ?œ¬ ê²½ìš° ?…? ¥ê°? id ì¶œë ¥
		System.out.println(id);
		ResultSet rs = null; // ?•­ëª©ëª… + ê²°ê³¼ ?°?´?„°ë¥? ?‹´ê³? ?ˆ?Š” ?…Œ?´ë¸?
		// ê¸°ë³¸?˜• ? •?ˆ˜/?‹¤?ˆ˜/ë¬¸ì/?…¼ë¦¬ë§Œ ê°’ìœ¼ë¡? ì´ˆê¸°?™”
		// ?‚˜ë¨¸ì? ?°?´?„°?˜•(ì°¸ì¡°?˜•) ì£¼ì†Œê°?! ?“¤?–´ê°? ?ˆ?Œ.
		// ì°¸ì¡°?˜• ë³??ˆ˜ë¥? ì´ˆê¸°?™”?•  ?•Œ?Š” null(ì£¼ì†Œê°? ?—†?‹¤?¼?Š” ?˜ë¯?)
		PlaylistVO bag = null;
		try {
			// 1.?˜¤?¼?´ 11g?? ?—°ê²°í•œ ë¶??’ˆ ?„¤? •
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQLê³? ?ë°? ?—°ê²°í•  ë¶??’ˆ ?„¤? • ?„±ê³?.");
			Locale.setDefault(Locale.US); // ë§? locale?—?Ÿ¬?‚˜?‹  ë¶„ë“¤ë§?!!!

			// 2.?˜¤?¼?´ 11g?— ?—°ê²°í•´ë³´ì.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?´ë¦„ì…? ¥"); //String, ?„?•„ë¬´ê°œ
			System.out.println("2. mySQL ?—°ê²? ?„±ê³?.");
			
			String sql = "select * from playlist where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQLë¬? ë¶??’ˆ(ê°ì²´)?œ¼ë¡? ë§Œë“¤?–´ì£¼ê¸° ?„±ê³?.");

			rs = ps.executeQuery(); // selectë¬? ? „?†¡?‹œ
			System.out.println("4. SQLë¬? ?˜¤?¼?´ë¡? ë³´ë‚´ê¸? ?„±ê³?.");
			if (rs.next()) { // ê²??ƒ‰ê²°ê³¼ê°? ?ˆ?Š”ì§? ?—¬ë¶??Š” rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
				
			} else {
				System.out.println("ê²??ƒ‰ê²°ê³¼ ?—†?Œ. ?„±ê³?.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel?? XXXXX!
		// return ?’¤?—?Š” ë°˜ë“œ?‹œ ?—¬?Ÿ¬ ?°?´?„°ë¥? ë¬¶ì–´?„œ ë¦¬í„´?•´ì£¼ì–´?•¼ ?•¨.
		// ê²??ƒ‰ê²°ê³¼ê°? ?ˆ?„ ?•Œ?Š” bag?— ?°?´?„°ê°? ?“¤?–´?ˆ?Œ.
		// ê²??ƒ‰ê²°ê³¼ê°? ?—†?„ ?•Œ?Š” bag?— ë¬´ì—‡?´ ?“¤?–´?ˆ?‚˜? null
		return bag;

	}
	
	public ArrayList<PlaylistVO> one55(String title) {
		System.out.println(title);
		ResultSet rs = null; // ?•­ëª©ëª… + ê²°ê³¼ ?°?´?„°ë¥? ?‹´ê³? ?ˆ?Š” ?…Œ?´ë¸?

		// ê°?ë°©ë“¤ ?„£?–´ì¤? ?° ì»¨í…Œ?´?„ˆ ?—­?• ?„ ë¶??’ˆ?´ ?•„?š”!
		// ArrayList<MovieVO> ==> MovieVOë§? ?“¤?–´ê°? arraylist?¼?Š” ?˜ë¯?
		ArrayList<PlaylistVO> list = new ArrayList<PlaylistVO>();

		PlaylistVO bag = null;
		try {
			// 1.?˜¤?¼?´ 11g?? ?—°ê²°í•œ ë¶??’ˆ ?„¤? •
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQLê³? ?ë°? ?—°ê²°í•  ë¶??’ˆ ?„¤? • ?„±ê³?.");
			Locale.setDefault(Locale.US); // ë§? locale?—?Ÿ¬?‚˜?‹  ë¶„ë“¤ë§?!!!

			// 2.?˜¤?¼?´ 11g?— ?—°ê²°í•´ë³´ì.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?´ë¦„ì…? ¥"); //String, ?„?•„ë¬´ê°œ
			System.out.println("2. mySQL ?—°ê²? ?„±ê³?.");
			// ì»¨íŠ¸ë¡? + ?‰¬?”„?Š¸ + f : ì½”ë“œ ??™ ? •ë¦?!

			String sql = "select id, title, artist from playlist where title like ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, "%" + title + "%");
			System.out.println("3. SQLë¬? ë¶??’ˆ(ê°ì²´)?œ¼ë¡? ë§Œë“¤?–´ì£¼ê¸° ?„±ê³?.");

			rs = ps.executeQuery(); // selectë¬? ? „?†¡?‹œ
			System.out.println("4. SQLë¬? ?˜¤?¼?´ë¡? ë³´ë‚´ê¸? ?„±ê³?.");
			while (rs.next()) { // ê²??ƒ‰ê²°ê³¼ê°? ?ˆ?Š”ì§? ?—¬ë¶??Š” rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				// 4. list?— bag?„ ì¶”ê??•´ì£¼ì.
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
		// 1.?˜¤?¼?´ 11g?? ?—°ê²°í•œ ë¶??’ˆ ?„¤? •
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQLê³? ?ë°? ?—°ê²°í•  ë¶??’ˆ ?„¤? • ?„±ê³?.");

		// 2.?˜¤?¼?´ 11g?— ?—°ê²°í•´ë³´ì.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		
		System.out.println("2. mySQL ?—°ê²? ?„±ê³?.");

		String sql = "delete from playlist where id = ? ";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		ps.setString(1, id);
		System.out.println("3. SQLë¬? ë¶??’ˆ(ê°ì²´)?œ¼ë¡? ë§Œë“¤?–´ì£¼ê¸° ?„±ê³?.");

		result = ps.executeUpdate();
		System.out.println("4. SQLë¬? ?˜¤?¼?´ë¡? ë³´ë‚´ê¸? ?„±ê³?.");
		if (result == 1) {
			System.out.println("?ƒˆ?‡´ ?„±ê³?.");
		}
		// System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return result;

}

// 1. ê°?ë°©ì„ ë°›ì•„?„œ ???¥?•´?‘?.
// 2. ?•„?š”?•  ?•Œ ê°?ë°©ì—?„œ ê°’ë“¤?„ ?•˜?‚˜?”© êº¼ë‚´?.
public int update(PlaylistVO bag) {
	int result = 0;
	try {
		// 1.?˜¤?¼?´ 11g?? ?—°ê²°í•œ ë¶??’ˆ ?„¤? •
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQLê³? ?ë°? ?—°ê²°í•  ë¶??’ˆ ?„¤? • ?„±ê³?.");
		Locale.setDefault(Locale.US); // ë§? locale?—?Ÿ¬?‚˜?‹  ë¶„ë“¤ë§?!!!

		// 2.?˜¤?¼?´ 11g?— ?—°ê²°í•´ë³´ì.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		// String data = JOptionPane.showInputDialog("?´ë¦„ì…? ¥"); //String, ?„?•„ë¬´ê°œ
		System.out.println("2. mySQL ?—°ê²? ?„±ê³?.");

		// ipaddress ==> InetAddress
		// String url = "http://wwww.naver.com";
		// URL u = new URL(url);
		// ?ë°”ëŠ” ë¶??’ˆì¡°ë¦½?‹?´?—¬?„œ,String?— ?„£?? ë¬¸ì?—´?„ ?Š¹? •?•œ ë¶??’ˆ?œ¼ë¡? ?¸?‹?•˜ì§? ëª»í•¨.
		// ?Š¹? •?•œ ë¶??’ˆ?œ¼ë¡? ?¸?‹?•˜? ¤ë©? ê·? ë¶??’ˆ?œ¼ë¡? ë§Œë“¤?–´ì£¼ì–´?•¼ ?•œ?‹¤.
		// SQLë¶??’ˆ?œ¼ë¡? ë§Œë“¤?–´ì£¼ì–´?•¼ ?•¨.
		// PreparedStatementê°? SQLë¶??’ˆ!!

		String sql = "update playlist set title = ? where id = ? ";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		ps.setString(1, bag.getTitle());
		ps.setString(2, bag.getId());
		System.out.println("3. SQLë¬? ë¶??’ˆ(ê°ì²´)?œ¼ë¡? ë§Œë“¤?–´ì£¼ê¸° ?„±ê³?.");

		result = ps.executeUpdate(); // 1
		// insert, update, deleteë¬¸ë§Œ!! sqlë¬? ?‹¤?–‰ê²°ê³¼ê°? int
		System.out.println("4. SQLë¬? ?˜¤?¼?´ë¡? ë³´ë‚´ê¸? ?„±ê³?.");
		if (result == 1) {
			System.out.println("?ˆ˜? • ?„±ê³?.");
		}
		// System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}

// public void add2() {
public int insert(PlaylistVO bag) {
	// 1. ê°?ë°©ì„ ë°›ì•„?„œ ë³??ˆ˜?— ?„£?–´ì£¼ì„¸?š”.
	int result = 0;

	try {
		// 1.?˜¤?¼?´ 11g?? ?—°ê²°í•œ ë¶??’ˆ ?„¤? •
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQLê³? ?ë°? ?—°ê²°í•  ë¶??’ˆ ?„¤? • ?„±ê³?.");
		Locale.setDefault(Locale.US); // ë§? locale?—?Ÿ¬?‚˜?‹  ë¶„ë“¤ë§?!!!

		// 2.?˜¤?¼?´ 11g?— ?—°ê²°í•´ë³´ì.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		// String data = JOptionPane.showInputDialog("?´ë¦„ì…? ¥"); //String, ?„?•„ë¬´ê°œ
		System.out.println("2. mySQL ?—°ê²? ?„±ê³?.");

		String sql = "insert into playlist values (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		// conë¶??’ˆ?œ¼ë¡? sql?Š¤?Š¸ë§ì— ?ˆ?Š” ê²? SQLë¶??’ˆ?œ¼ë¡? ë§Œë“¤?–´ì£¼ì„¸?š”.
		// Rë¹¼ê³ , ?¸?±?Š¤ 0ë¶??„° ?‹œ?‘!!
		// ?œ ?¼?•˜ê²? db?? ?¸?±?Š¤ê°? 1ë¶??„° ?‹œ?‘!!
		// 2. ê°?ë°©ì—?„œ ê°’ë“¤?„ ?•˜?‚˜?”© êº¼ë‚´?“°?„¸?š”.
		ps.setString(1, bag.getId()); // ps.setInt(1, no);
		ps.setString(2, bag.getTitle());
		ps.setString(3, bag.getArtist());
		ps.setString(4, bag.getGenre());
		ps.setString(5, bag.getImg());

		// ==> insert into hr.MEMBER values ('a','a','a','a');
		System.out.println("3. SQLë¬? ë¶??’ˆ(ê°ì²´)?œ¼ë¡? ë§Œë“¤?–´ì£¼ê¸° ?„±ê³?.");

		result = ps.executeUpdate(); // 1
		System.out.println("4. SQLë¬? ?˜¤?¼?´ë¡? ë³´ë‚´ê¸? ?„±ê³?.");
		if (result == 1) {
			System.out.println("?šŒ?›ê°??… ?„±ê³?!");
		}
		// System.out.println(result);
	} catch (Exception e) {
		// insertê°? ? œ??ë¡? ?•ˆ?œ ê²½ìš°, ?œ„?—˜?•œ ?ƒ?™©?´?¼ê³? ?Œ?‹¨?•˜ê³?
		// catchê°? ?‹¤?–‰
		// ?‹¤?–‰?œ Row?ˆ˜ê°? ?—†?œ¼ë¯?ë¡? Result?— 0?„ ?„£?–´ì£¼ì.!
		// result = 0;
		e.printStackTrace();
	}

	System.out.println(result);
	return result;
}
}