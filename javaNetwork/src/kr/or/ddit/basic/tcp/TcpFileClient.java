package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpFileClient {

	private Socket socket;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	private DataOutputStream dout;
	
	
	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	}


	private void clientStart() {
		//전송할 파일 정보를 갖는 File객체 생성
		File file = new File("d:/d_other/펭귄.jpg");
		String fileName = file.getName(); // 파일 이름 구하기.
		if(!file.exists()) {
			//전송할 파일이 있는지 검사
			System.out.println(fileName + "파일이 없습니다...");
			System.out.println("파일 전송 작업을 중단합니다...");
			return;
		}
		try {
			socket = new Socket("localhost",7777);
			
			System.out.println("파일 전송 시작...");
			
			//서버에 접속하면 첫번째로 '파일명'을 전송한다.
			
			dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(fileName);
			
			
			//파일 읽기용 스트림 객체 생성
			bin = new BufferedInputStream(new FileInputStream(file));
			
			//전송용 스트림 객체 생성
			bout = new BufferedOutputStream(socket.getOutputStream());
			
			//파일을 읽어서 Socket으로 전송(출력)하기
			
			byte[] temp = new byte[1024];
			int length = 0;
			while((length=bin.read(temp))!=-1) {
				bout.write(temp,0,length);
			}
			bout.flush();
			
			System.out.println("파일전송완료...");
			
			
		} catch (Exception e) {
			System.out.println("파일전송실패");
			e.printStackTrace();
		}finally {
			//사용했던 스크림과 Socket닫기
			if(dout!=null) try { dout.close();} catch(IOException e) {};
			if(bout!=null) try { bout.close();} catch(IOException e) {};
			if(bin!=null) try { bin.close();} catch(IOException e) {};
			if(socket!=null) try { socket.close();} catch(IOException e) {};
			
		}
	}
}
