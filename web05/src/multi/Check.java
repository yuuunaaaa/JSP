package multi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/check.do")
public class Check extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Check 서블릿 객체가 하나 만들어");
	}
	
	@Override
	public void destroy() {
		System.out.println("Check 서블릿 소멸됨");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String today = request.getParameter("today");
		String result = "그냥있자";
		
		if (today.equals("맑음")) {
			result = "나가자";
		} else if (today.equals("흐림")) {
			result = "코딩";
		} else if (today.equals("비옴")) {
			result = "쇼핑";
		}
		out.print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String pass = request.getParameter("pass");
		
		if (pass.equals("나는왕이다")) {
			out.print("들어오세요");
		} else {
			out.print("들어올 수 없습니다");
		}
	}

}
