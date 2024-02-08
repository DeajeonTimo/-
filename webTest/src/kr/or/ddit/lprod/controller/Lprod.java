package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;


@WebServlet("/lprod.do")
public class Lprod extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("apllication/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		LprodServiceImpl service = LprodServiceImpl.getInstance();
		
		List<LprodVO> list = service.selectAllLprod();
		
		Gson gson = new Gson();
		
		 String json = gson.toJson(list);
		 
		 out.write(json);
		 
		response.flushBuffer();
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
