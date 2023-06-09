package com.multi.mvc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;

//import ?λ©΄DB?°κ²?.PlaylistVO;
@Component
public class PlaylistDAO { // CRUD
	
	public ArrayList<PlaylistVO> list() {
		ResultSet rs = null; // ?­λͺ©λͺ + κ²°κ³Ό ?°?΄?°λ₯? ?΄κ³? ?? ??΄λΈ?

		// κ°?λ°©λ€ ?£?΄μ€? ?° μ»¨ν?΄? ?­? ? λΆ???΄ ??!
		// ArrayList<PlaylistVO> ==> PlaylistVOλ§? ?€?΄κ°? arraylist?Ό? ?λ―?
		ArrayList<PlaylistVO> list = new ArrayList<PlaylistVO>();

		PlaylistVO bag = null;
		try {
			// 1.?€?Ό?΄ 11g?? ?°κ²°ν λΆ?? ?€? 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQLκ³? ?λ°? ?°κ²°ν  λΆ?? ?€?  ?±κ³?.");
			Locale.setDefault(Locale.US); // λ§? locale??¬??  λΆλ€λ§?!!!

			// 2.?€?Ό?΄ 11g? ?°κ²°ν΄λ³΄μ.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?΄λ¦μ? ₯"); //String, ??λ¬΄κ°
			System.out.println("2. mySQL ?°κ²? ?±κ³?.");
			// μ»¨νΈλ‘? + ?¬??Έ + f : μ½λ ?? ? λ¦?!

			String sql = "select * from playlist";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// ?­? !!!! ps.setString(1, id);
			System.out.println("3. SQLλ¬? λΆ??(κ°μ²΄)?Όλ‘? λ§λ€?΄μ£ΌκΈ° ?±κ³?.");

			rs = ps.executeQuery(); // selectλ¬? ? ?‘?
			System.out.println("4. SQLλ¬? ?€?Ό?΄λ‘? λ³΄λ΄κΈ? ?±κ³?.");
			while (rs.next()) { // κ²??κ²°κ³Όκ°? ??μ§? ?¬λΆ?? rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
				
				// 3. μ»¨ν?΄?? κ°?λ°? ?£κΈ?(row? κ°μ)
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
		// return ?€?? λ°λ? ?¬?¬ ?°?΄?°λ₯? λ¬Άμ΄? λ¦¬ν΄?΄μ£Όμ΄?Ό ?¨.
		// κ²??κ²°κ³Όκ°? ?? ?? bag? ?°?΄?°κ°? ?€?΄??.
		// κ²??κ²°κ³Όκ°? ?? ?? bag? λ¬΄μ?΄ ?€?΄??? null
		return list;

	}
	
	public PlaylistVO one(String id) {
		// κ²?? κ²°κ³Όκ°? null?΄ ?¬ κ²½μ° ?? ₯κ°? id μΆλ ₯
		System.out.println(id);
		ResultSet rs = null; // ?­λͺ©λͺ + κ²°κ³Ό ?°?΄?°λ₯? ?΄κ³? ?? ??΄λΈ?
		// κΈ°λ³Έ? ? ?/?€?/λ¬Έμ/?Όλ¦¬λ§ κ°μΌλ‘? μ΄κΈ°?
		// ?λ¨Έμ? ?°?΄?°?(μ°Έμ‘°?) μ£Όμκ°?! ?€?΄κ°? ??.
		// μ°Έμ‘°? λ³??λ₯? μ΄κΈ°??  ?? null(μ£Όμκ°? ??€?Ό? ?λ―?)
		PlaylistVO bag = null;
		try {
			// 1.?€?Ό?΄ 11g?? ?°κ²°ν λΆ?? ?€? 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQLκ³? ?λ°? ?°κ²°ν  λΆ?? ?€?  ?±κ³?.");
			Locale.setDefault(Locale.US); // λ§? locale??¬??  λΆλ€λ§?!!!

			// 2.?€?Ό?΄ 11g? ?°κ²°ν΄λ³΄μ.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?΄λ¦μ? ₯"); //String, ??λ¬΄κ°
			System.out.println("2. mySQL ?°κ²? ?±κ³?.");
			
			String sql = "select * from playlist where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQLλ¬? λΆ??(κ°μ²΄)?Όλ‘? λ§λ€?΄μ£ΌκΈ° ?±κ³?.");

			rs = ps.executeQuery(); // selectλ¬? ? ?‘?
			System.out.println("4. SQLλ¬? ?€?Ό?΄λ‘? λ³΄λ΄κΈ? ?±κ³?.");
			if (rs.next()) { // κ²??κ²°κ³Όκ°? ??μ§? ?¬λΆ?? rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
				
			} else {
				System.out.println("κ²??κ²°κ³Ό ??. ?±κ³?.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel?? XXXXX!
		// return ?€?? λ°λ? ?¬?¬ ?°?΄?°λ₯? λ¬Άμ΄? λ¦¬ν΄?΄μ£Όμ΄?Ό ?¨.
		// κ²??κ²°κ³Όκ°? ?? ?? bag? ?°?΄?°κ°? ?€?΄??.
		// κ²??κ²°κ³Όκ°? ?? ?? bag? λ¬΄μ?΄ ?€?΄??? null
		return bag;

	}
	
	public ArrayList<PlaylistVO> one55(String title) {
		System.out.println(title);
		ResultSet rs = null; // ?­λͺ©λͺ + κ²°κ³Ό ?°?΄?°λ₯? ?΄κ³? ?? ??΄λΈ?

		// κ°?λ°©λ€ ?£?΄μ€? ?° μ»¨ν?΄? ?­? ? λΆ???΄ ??!
		// ArrayList<MovieVO> ==> MovieVOλ§? ?€?΄κ°? arraylist?Ό? ?λ―?
		ArrayList<PlaylistVO> list = new ArrayList<PlaylistVO>();

		PlaylistVO bag = null;
		try {
			// 1.?€?Ό?΄ 11g?? ?°κ²°ν λΆ?? ?€? 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQLκ³? ?λ°? ?°κ²°ν  λΆ?? ?€?  ?±κ³?.");
			Locale.setDefault(Locale.US); // λ§? locale??¬??  λΆλ€λ§?!!!

			// 2.?€?Ό?΄ 11g? ?°κ²°ν΄λ³΄μ.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("?΄λ¦μ? ₯"); //String, ??λ¬΄κ°
			System.out.println("2. mySQL ?°κ²? ?±κ³?.");
			// μ»¨νΈλ‘? + ?¬??Έ + f : μ½λ ?? ? λ¦?!

			String sql = "select id, title, artist from playlist where title like ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, "%" + title + "%");
			System.out.println("3. SQLλ¬? λΆ??(κ°μ²΄)?Όλ‘? λ§λ€?΄μ£ΌκΈ° ?±κ³?.");

			rs = ps.executeQuery(); // selectλ¬? ? ?‘?
			System.out.println("4. SQLλ¬? ?€?Ό?΄λ‘? λ³΄λ΄κΈ? ?±κ³?.");
			while (rs.next()) { // κ²??κ²°κ³Όκ°? ??μ§? ?¬λΆ?? rs.next()
				bag = new PlaylistVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				// 4. list? bag? μΆκ??΄μ£Όμ.
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
		// 1.?€?Ό?΄ 11g?? ?°κ²°ν λΆ?? ?€? 
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQLκ³? ?λ°? ?°κ²°ν  λΆ?? ?€?  ?±κ³?.");

		// 2.?€?Ό?΄ 11g? ?°κ²°ν΄λ³΄μ.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		
		System.out.println("2. mySQL ?°κ²? ?±κ³?.");

		String sql = "delete from playlist where id = ? ";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		ps.setString(1, id);
		System.out.println("3. SQLλ¬? λΆ??(κ°μ²΄)?Όλ‘? λ§λ€?΄μ£ΌκΈ° ?±κ³?.");

		result = ps.executeUpdate();
		System.out.println("4. SQLλ¬? ?€?Ό?΄λ‘? λ³΄λ΄κΈ? ?±κ³?.");
		if (result == 1) {
			System.out.println("??΄ ?±κ³?.");
		}
		// System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return result;

}

// 1. κ°?λ°©μ λ°μ? ???₯?΄??.
// 2. ???  ? κ°?λ°©μ? κ°λ€? ???© κΊΌλ΄?.
public int update(PlaylistVO bag) {
	int result = 0;
	try {
		// 1.?€?Ό?΄ 11g?? ?°κ²°ν λΆ?? ?€? 
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQLκ³? ?λ°? ?°κ²°ν  λΆ?? ?€?  ?±κ³?.");
		Locale.setDefault(Locale.US); // λ§? locale??¬??  λΆλ€λ§?!!!

		// 2.?€?Ό?΄ 11g? ?°κ²°ν΄λ³΄μ.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		// String data = JOptionPane.showInputDialog("?΄λ¦μ? ₯"); //String, ??λ¬΄κ°
		System.out.println("2. mySQL ?°κ²? ?±κ³?.");

		// ipaddress ==> InetAddress
		// String url = "http://wwww.naver.com";
		// URL u = new URL(url);
		// ?λ°λ λΆ??μ‘°λ¦½??΄?¬?,String? ?£?? λ¬Έμ?΄? ?Ή? ? λΆ???Όλ‘? ?Έ??μ§? λͺ»ν¨.
		// ?Ή? ? λΆ???Όλ‘? ?Έ??? €λ©? κ·? λΆ???Όλ‘? λ§λ€?΄μ£Όμ΄?Ό ??€.
		// SQLλΆ???Όλ‘? λ§λ€?΄μ£Όμ΄?Ό ?¨.
		// PreparedStatementκ°? SQLλΆ??!!

		String sql = "update playlist set title = ? where id = ? ";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		ps.setString(1, bag.getTitle());
		ps.setString(2, bag.getId());
		System.out.println("3. SQLλ¬? λΆ??(κ°μ²΄)?Όλ‘? λ§λ€?΄μ£ΌκΈ° ?±κ³?.");

		result = ps.executeUpdate(); // 1
		// insert, update, deleteλ¬Έλ§!! sqlλ¬? ?€?κ²°κ³Όκ°? int
		System.out.println("4. SQLλ¬? ?€?Ό?΄λ‘? λ³΄λ΄κΈ? ?±κ³?.");
		if (result == 1) {
			System.out.println("??  ?±κ³?.");
		}
		// System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}

// public void add2() {
public int insert(PlaylistVO bag) {
	// 1. κ°?λ°©μ λ°μ? λ³??? ?£?΄μ£ΌμΈ?.
	int result = 0;

	try {
		// 1.?€?Ό?΄ 11g?? ?°κ²°ν λΆ?? ?€? 
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.mySQLκ³? ?λ°? ?°κ²°ν  λΆ?? ?€?  ?±κ³?.");
		Locale.setDefault(Locale.US); // λ§? locale??¬??  λΆλ€λ§?!!!

		// 2.?€?Ό?΄ 11g? ?°κ²°ν΄λ³΄μ.(java --- oracle)
		// String url = "jdbc:mysql://localhost:3306/multi";
		String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password); // Connection
		// String data = JOptionPane.showInputDialog("?΄λ¦μ? ₯"); //String, ??λ¬΄κ°
		System.out.println("2. mySQL ?°κ²? ?±κ³?.");

		String sql = "insert into playlist values (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
		// conλΆ???Όλ‘? sql?€?Έλ§μ ?? κ²? SQLλΆ???Όλ‘? λ§λ€?΄μ£ΌμΈ?.
		// RλΉΌκ³ , ?Έ?±?€ 0λΆ??° ??!!
		// ? ?Ό?κ²? db?? ?Έ?±?€κ°? 1λΆ??° ??!!
		// 2. κ°?λ°©μ? κ°λ€? ???© κΊΌλ΄?°?Έ?.
		ps.setString(1, bag.getId()); // ps.setInt(1, no);
		ps.setString(2, bag.getTitle());
		ps.setString(3, bag.getArtist());
		ps.setString(4, bag.getGenre());
		ps.setString(5, bag.getImg());

		// ==> insert into hr.MEMBER values ('a','a','a','a');
		System.out.println("3. SQLλ¬? λΆ??(κ°μ²΄)?Όλ‘? λ§λ€?΄μ£ΌκΈ° ?±κ³?.");

		result = ps.executeUpdate(); // 1
		System.out.println("4. SQLλ¬? ?€?Ό?΄λ‘? λ³΄λ΄κΈ? ?±κ³?.");
		if (result == 1) {
			System.out.println("??κ°?? ?±κ³?!");
		}
		// System.out.println(result);
	} catch (Exception e) {
		// insertκ°? ? ??λ‘? ?? κ²½μ°, ??? ??©?΄?Όκ³? ??¨?κ³?
		// catchκ°? ?€?
		// ?€?? Row?κ°? ??Όλ―?λ‘? Result? 0? ?£?΄μ£Όμ.!
		// result = 0;
		e.printStackTrace();
	}

	System.out.println(result);
	return result;
}
}