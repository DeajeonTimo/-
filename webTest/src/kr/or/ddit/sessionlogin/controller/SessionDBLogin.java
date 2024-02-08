package kr.or.ddit.sessionlogin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.sessionlogin.service.IMemberService;
import kr.or.ddit.sessionlogin.service.MemberServiceImpl;
import kr.or.ddit.sessionlogin.vo.MemberVO;


@WebServlet("/sessionDBLogin.do")
public class SessionDBLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//id와 패스워드 구하기
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		
		//id와 패스워드를 MemberVO객체에 저장한다.
		MemberVO paramMemVo = new MemberVO();
		paramMemVo.setMem_id(userId);
		paramMemVo.setMem_pass(userPass);
		
		// service 객체를 생성한 후 Login처리를 하는 매서드를 호출하여 반환값을 받아온다.
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVO memVo = service.getLoginMember(paramMemVo);
		
		HttpSession session = request.getSession();
		
		//로그인 성공 여부를 검사한다.
		if(memVo!=null) {
			//로그인 성공시 Session에 로그인 정보 저장하기
			session.setAttribute("LoginMember", memVo);
		}
		//로그인 페이지로 이동
		response.sendRedirect(request.getContextPath()+"/basic/sessionDB/sessionDBLogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
