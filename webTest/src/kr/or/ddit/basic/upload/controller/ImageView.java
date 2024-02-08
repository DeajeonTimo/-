package kr.or.ddit.basic.upload.controller;

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

import kr.or.ddit.basic.upload.service.FileInfoServiceImpl;
import kr.or.ddit.basic.upload.vo.FileInfoVO;


@WebServlet("/images/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//파라미터로 넘어온 파일번호 구하기
		int fileNo = Integer.parseInt(request.getParameter("fileno"));
		
		//파일 번호에 해당하는 파일 정보를 DB에서 가져온다
		
		FileInfoServiceImpl service = FileInfoServiceImpl.getInstance();
		
		FileInfoVO fvo = service.getFileinfo(fileNo);
		
		String uploadPath = "d:/d_other/uploadFiles";
		
		//업로드된 파일들이 저장된 폴더 설정
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String imgPath = uploadPath + File.separator + fvo.getSave_file_name();
		
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
