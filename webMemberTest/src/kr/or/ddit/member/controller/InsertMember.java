package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.member.service.ITeamMemberService;
import kr.or.ddit.member.service.TeamMemberService;
import kr.or.ddit.member.vo.TeamMemberVO;


@WebServlet("/insertMember.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*30, maxRequestSize = 1024*1024*100 )
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		// 업로드된 파일들이 저장될 폴더 설정(서버 컴퓨터)
		String uploadPath = "d:/d_other/uploadFiles2";

		//저장될 폴더가 없으면 새로 생성한다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdir();
		}

		Part part = request.getPart("memfile");

		String fileName = extractFileName(part);

		String saveFileName = UUID.randomUUID().toString() + "_"+fileName;


		try {
			//Upload된 파일을 지정한 '업로드 폴더'에 저장하기
			// 저장하는 매서드 ==> Part객체.writer()매서드 이용
			part.write(uploadPath + File.separator + saveFileName );
		}catch(IOException e) {
			e.printStackTrace();
		}


		
		
		
		String id= request.getParameter("memid");
		String pass= request.getParameter("mempass");
		String pass2= request.getParameter("mempass2");
		String name= request.getParameter("memname");
		String tel= request.getParameter("memtel");
		String addr= request.getParameter("memaddr");
		
		TeamMemberVO vo = new TeamMemberVO();
		
		vo.setMem_id(id);
		vo.setMem_pass(pass);
		vo.setMem_name(name);
		vo.setMem_tel(tel);
		vo.setMem_addr(addr);
		vo.setMem_photo(saveFileName);
		
		ITeamMemberService service = TeamMemberService.getInstance();
		
		int res = service.insertMember(vo);
		
		String result = "실패";
		if(res>0) {
			result = "성공";
		}
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/teammember/signup.jsp").forward(request, response);
		
		
	}
	
	public String extractFileName(Part part) {
		String fileName = null; // 반환값(파일명)이 저장될 변수
		String dispositionStr = part.getHeader("content-disposition");
		String[] itemArr = dispositionStr.split(";");
		
		for(String item : itemArr) {
			if(item.trim().startsWith("filename")) {
				//filename="text1.txt"
				fileName = item.substring(item.indexOf("=")+2,item.length()-1);
			}
		}
		
		return fileName;
	}

}
