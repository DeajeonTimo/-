package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//저장된 쿠키 배열을 가져온다
		Cookie[] cookieArr = request.getCookies();
		
		//저장된 쿠키 배열에서 이름이 count인 쿠키가 있는지 찾는다
		boolean chk = false;
		Cookie cookie = null;
		for(Cookie ck : cookieArr) {
			String name = ck.getName();
			
			//count이름의 쿠키가 있는지 확인한다.
			if("count".equals(name)) {
				chk = true;
				cookie = ck;
			}
		}
		//쿠키가 없으면 쿠키를 만든다
		if(!chk) {
			cookie = new Cookie("count", "0");
		}
		//값을 늘린다.
		int count = Integer.parseInt(cookie.getValue())+1;
		
		//늘린 값을 새로 저장한다.
		cookie.setValue(count+"");
		
		//쿠키를 등록한다.
		response.addCookie(cookie);
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Cookie 카운트 늘리기</title></head>");
		out.println("<body>");
		out.println("<h3>어서오세요 당신은"+count+"번째 방문입니다.</h3><br><br>");		
		out.println("<a href='"+request.getContextPath()+"/cookieCountServlet.do'>카운트 증가하기</a>");		
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");		
		out.println("</body>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
