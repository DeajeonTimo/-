package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.member.service.ITeamMemberService;
import kr.or.ddit.member.service.TeamMemberService;
import kr.or.ddit.member.vo.TeamMemberVO;


@WebServlet("/memberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ITeamMemberService service = TeamMemberService.getInstance();
		
		List<TeamMemberVO> list = service.selectAllMember();
		
		Gson gson = new Gson();
		
		String reqData = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("apllication/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.write(reqData);
		
		response.flushBuffer();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
