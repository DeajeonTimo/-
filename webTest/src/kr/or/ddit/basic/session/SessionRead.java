package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//저장된  Session 값 읽어오기
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1. Session 객체 구하기
		HttpSession session = request.getSession();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Session 읽기연습</title></head>");
		out.println("<body>");
		out.println("<h3>저장된 Session값 확인하기</h3><br><br>");
		out.println("<h3> Session 데이터 1개 확인하기</h3><br><br>");
		//2. Session객체의 getAttribute()매서드를 이용하여 Session값 구하기
		// 형식) Session객체.getAttribute("key값");
		//		==> 'key값'이 없으면 null을 반환한다.
		String sessionValue = (String)session.getAttribute("testSession");
		if(sessionValue!=null) {
			out.println("testSession의 세션값 ==> "+sessionValue);
		}else {
			out.println("현재 세션에는 'testSession' 키값이 없습니다...");
		}
		out.println("<br><hr><br>");
		
		out.println("<h3>전체 세션 데이터 확인하기</h3>");
		
		//Session에 저장된 모든 key값들 구하기
		Enumeration<String> sessionKey = session.getAttributeNames();
		
		int cnt=0; // key값들의 개수가 저장될 변수
		
		out.println("<ul>");
		while(sessionKey.hasMoreElements()) {
			cnt++;
			String key = sessionKey.nextElement(); // 1개의 key값 구하기
			out.println("<li>"+key+ " : "+session.getAttribute(key) + "</li>");
		}
		if(cnt==0) {
			out.println("<li>Session에 저장된 데이터가 하나도 없습니다.</li>");			
		}
		out.println("</ul>");
		out.println("<br><hr><br>");
		
		//세션 ID = > 세션을 구분하기 위한 고유한 값
		out.println("세션 ID : " + session.getId() + "<br>");
		
		// 생성시간 ==> 1970년 1월 1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션생성시간  : " + session.getCreationTime() + "<br>");
		
		// 가장 최근 접근 시간 : 1970년 1월 1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 최근 접근 시간  : " + session.getLastAccessedTime() + "<br>");
		
		// 세션 유효시간 ==> (초 단위)
		// 유효시간 설정하는 매서드 => session.setMaxInactiveInterval(시간)
		out.println("세션 유효 시간  : " + session.getMaxInactiveInterval() + "<br>");
		
		out.println("<br><hr><br>");
		out.println("<a href='"+request.getContextPath()+"/basic/session/sessionTest01.jsp'>시작 문서로 이동하기</a>");	
		
		out.println("</body>");
		out.println("</html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
