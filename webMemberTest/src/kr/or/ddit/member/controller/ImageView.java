package kr.or.ddit.member.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
 * Servlet implementation class ImageView
 */
@WebServlet("/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		ITeamMemberService service = TeamMemberService.getInstance();
		
		TeamMemberVO vo = service.selectMember(id);
		
		System.out.println(vo.getMem_photo());
		
		String uploadPath = "d:/d_other/uploadFiles2";
		
		//업로드된 파일들이 저장된 폴더 설정
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String imgPath = uploadPath + File.separator + vo.getMem_photo();
		
		File file = new File(imgPath);
		
		if(file.exists()) { // 이미지 파일이 있을때...
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				//출력용
				bout = new BufferedOutputStream(response.getOutputStream());
				//파일 입력용
				bin = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				while((len = bin.read(temp))>0) {
					bout.write(temp,0,len);
				}
				bout.flush();
			} catch (Exception e) {
				System.out.println("파일 입출력 오류 : "+e.getMessage());
			}finally {
				if(bin!=null) try {bin.close();}catch(IOException e) {}
				if(bout!=null) try {bin.close();}catch(IOException e) {}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
