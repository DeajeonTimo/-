package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = "";
		String pass = "";
		String check = "";
		
		if(request.getParameter("id")!=null) {
			id = request.getParameter("id");
		}
		
		if(request.getParameter("pass")!=null) {
			pass = request.getParameter("pass");
		}
		
		if(request.getParameter("check")!=null) {
			check = request.getParameter("check");
		}
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		if(check.equals("check")) {
			Cookie cookie = new Cookie("id",id);
			response.addCookie(cookie);
		}else{
			Cookie[] cookieArr = request.getCookies();
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();
				if("id".equals(name)) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		if(id.equals("test") && pass.equals("1234")) {
			response.sendRedirect(request.getContextPath()+"/basic/cookie/cookieMain.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/basic/cookie/cookieLogin.jsp");
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
