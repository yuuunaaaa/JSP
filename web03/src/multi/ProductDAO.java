package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Locale;

//import 화면DB연결.MemberVO;

public class ProductDAO { // CRUD

	public int insert(ProductVO bag) {
		{
			// 1. 가방을 받아서 변수에 넣어주세요.
			int result = 0;

			try {
				// 1.오라클 11g와 연결한 부품 설정
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("1.mySQL과 자바 연결할 부품 설정 성공.");
				Locale.setDefault(Locale.US); // 맥 locale에러나신 분들만!!!

				// 2.오라클 11g에 연결해보자.(java --- oracle)
				// String url = "jdbc:mysql://localhost:3306/multi";
				String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
				String user = "root";
				String password = "1234";
				Connection con = DriverManager.getConnection(url, user, password); // Connection
				// String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
				System.out.println("2. mySQL 연결 성공.");

				String sql = "insert into product values (?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
				// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
				// R빼고, 인덱스 0부터 시작!!
				// 유일하게 db은 인덱스가 1부터 시작!!
				// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
				ps.setString(1, bag.getId()); // ps.setInt(1, no);
				ps.setString(2, bag.getName());
				ps.setString(3, bag.getContent());
				ps.setString(4, bag.getPrice());
				ps.setString(5, bag.getCompany());
				ps.setString(6, bag.getImg());

				// ==> insert into hr.MEMBER values ('a','a','a','a');
				System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

				result = ps.executeUpdate(); // 1
				System.out.println("4. SQL문 오라클로 보내기 성공.");
				if (result == 1) {
					System.out.println("회원가입 성공!");
				}
				// System.out.println(result);
			} catch (Exception e) {
				// insert가 제대로 안된 경우, 위험한 상황이라고 판단하고
				// catch가 실행
				// 실행된 Row수가 없으므로 Result에 0을 넣어주자.!
				// result = 0;
				e.printStackTrace();
			}

			System.out.println(result);
			return result;
		}
	}
}
