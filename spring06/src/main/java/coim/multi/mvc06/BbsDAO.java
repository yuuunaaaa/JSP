package coim.multi.mvc06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;

//���̺� �ϳ��� DAO�ϳ�! ==> CUD�� �ϼ�!!
@Component
public class BbsDAO {

	public ArrayList<BbsVO> list() {
		ResultSet rs = null; // �׸�� + ��� �����͸� ��� �ִ� ���̺�

		// ����� �־��� ū �����̳� ������ ��ǰ�� �ʿ�!
		// ArrayList<MemberVO> ==> MemberVO�� �� arraylist��� �ǹ�
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();

		BbsVO bag = null;
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

			String sql = "select * from bbs";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// ����!!!! ps.setString(1, id);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			rs = ps.executeQuery(); // select�� ���۽�
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			while (rs.next()) { // �˻������ �ִ��� ���δ� rs.next()
				// true�̸� �ִٶ�� �ǹ�, false�̸� ���ٶ�� �ǹ�
				// 1. �˻������ ������,
				// System.out.println("�˻���� ����. ����.");
				int no2 = rs.getInt(1); // no
				String title = rs.getString(2); // title
				String content = rs.getString(3); // content
				String writer = rs.getString(4); // writer
				System.out.println(no2 + " " + title + " " + content + " " + writer);
				// �˻������ �˻�ȭ�� UI�κ��� �־�� ��.
				bag = new BbsVO();
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);

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

	
	public BbsVO one(int no) {
		ResultSet rs = null; // �׸�� + ��� �����͸� ��� �ִ� ���̺�
		BbsVO bag = null;
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

			String sql = "select * from bbs where NO = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, no);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			rs = ps.executeQuery(); // select�� ����� <�׸��+Row> ���̺�!!
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if (rs.next()) { // �˻������ �ִ��� ���δ� rs.next()
				// true�̸� �ִٶ�� �ǹ�, false�̸� ���ٶ�� �ǹ�
				System.out.println("�˻���� ����. ����.");
				int no2 = rs.getInt(1); // no
				String title = rs.getString(2); // title
				String content = rs.getString(3); // content
				String writer = rs.getString(4); // writer
				System.out.println(no2 + " " + title + " " + content + " " + writer);
				// �˻������ �˻�ȭ�� UI�κ��� �־�� ��.
				bag = new BbsVO();
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
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

	public void delete(int no) {
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

			String sql = "delete from bbs where no = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, no);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			ps.executeUpdate();
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(BbsVO bag) {
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

			String sql = "update bbs set content = ? where NO = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, bag.getContent());
			ps.setInt(2, bag.getNo());
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			ps.executeUpdate(); // insert, update, delete����!! sql�� �������� int
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void add2() {
	public void insert(BbsVO bag) {

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

			String sql = "insert into bbs(title, content, writer) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, bag.getTitle());
			ps.setString(2, bag.getContent());
			ps.setString(3, bag.getWriter());
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			ps.executeUpdate();
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
