package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.ITeamMemberService;
import kr.or.ddit.member.service.TeamMemberService;

@WebServlet("/checkMemberId.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*30, maxRequestSize = 1024*1024*100 )
public class CheckMemberId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		ITeamMemberService service = TeamMemberService.getInstance();
		
		int res = service.selectCountMember(id);
		
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("/teammember/idView.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
