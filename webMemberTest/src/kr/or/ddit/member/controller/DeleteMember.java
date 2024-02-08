package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.ITeamMemberService;
import kr.or.ddit.member.service.TeamMemberService;
import kr.or.ddit.member.vo.TeamMemberVO;

/**
 * Servlet implementation class DeleteMember
 */
@WebServlet("/deleteMember.do")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		ITeamMemberService service = TeamMemberService.getInstance();
		
		int res = service.deleteMember(id);
		
		response.setCharacterEncoding("utf-8");
		
		response.sendRedirect(request.getContextPath()+"/teammember/memberList.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
