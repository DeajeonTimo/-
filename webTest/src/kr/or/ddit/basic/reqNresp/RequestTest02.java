package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		int input1  =  Integer.parseInt(request.getParameter("input1"));
		int input2  =  Integer.parseInt(request.getParameter("input2"));
		String sign = request.getParameter("sign");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset:utf-8");
		PrintWriter out = response.getWriter();
	
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Request연습</title></head>");
		out.println("<body>");
		out.println("<h2>Requset의 파라미터 데이터 받기</h2><br>");
		out.println("<h2>(url매핑 :"+request.getRequestURI()+"</h2><br>");
		out.println("<hr>");
		out.println("<h1>계산 결과</h1>");
		out.println("<hr>");
		double res =0; 
		switch(sign) {
			case "+" : res = input1 + input2;
				break;
			case "-" : res = input1 - input2;
				break;
			case "*" : res = input1 * input2;
				break;
			case "/" : res = input1 / input2;
				break;
			case "%" : res = input1 % input2;
				break;
		}
		
		
		out.print(input1+ sign+ input2 + "=" + res);
		
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
