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
public class ReplyDAO {

	public ArrayList<ReplyVO> list(int bbsno) {
		ResultSet rs = null; // �׸�� + ��� �����͸� ��� �ִ� ���̺�

		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();

		ReplyVO bag = null;
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

			//����� Ư�� �ϳ��� �Խù��� ���� ����Ʈ�̹Ƿ� 
			//Ư�� �Խù��� ������ ��� ����Ʈ�� ������ �;� ��.
			String sql = "select * from reply where bbsno = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, bbsno);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");

			rs = ps.executeQuery(); // select�� ���۽�
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			while (rs.next()) { // �˻������ �ִ��� ���δ� rs.next()
				// true�̸� �ִٶ�� �ǹ�, false�̸� ���ٶ�� �ǹ�
				// 1. �˻������ ������,
				// System.out.println("�˻���� ����. ����.");
				int no = rs.getInt(1);
				int bbsno1 = rs.getInt(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				System.out.println(no + " " + bbsno1 + " " + content + " " + writer);

				// 4. list�� bag�� �߰�������.
				bag = new ReplyVO();
				bag.setNo(no);
				bag.setBbsno(bbsno1);
				bag.setContent(content);
				bag.setWriter(writer);
				
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

	

	// public void add2() {
	public void insert(ReplyVO bag) {

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

			String sql = "insert into reply(bbsno, content, writer) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, bag.getBbsno());
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