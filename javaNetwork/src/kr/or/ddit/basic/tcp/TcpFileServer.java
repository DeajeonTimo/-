package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {

	private ServerSocket server;
	private Socket socket;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	private DataInputStream din;
	
	public static void main(String[] args) {
		new TcpFileServer().serverStart();
	}

	private void serverStart() {
		//저장할 폴더 정보를 갖는 File 객체 생성
		File saveDir = new File("d:/d_other/upload");
		
		if(!saveDir.exists()) {
			//저장할 폴더가 없으면 새로 생성한다.
			saveDir.mkdirs();
		}
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비 되었습니다...");
			socket = server.accept();
			
			System.out.println("파일저장시작...");
			
			//클라이언트가 첫번째로 보내온 파일명을 받는다.
			din = new DataInputStream(socket.getInputStream());
			String fileName = din.readUTF();
			
			//저장할 폴더와 파일명을 지정하여 File객체 생성하기
			File saveFile = new File(saveDir,fileName);
						
			//수신용 스트림 객체 생성
			bin = new BufferedInputStream(socket.getInputStream());
			
			// 파일 저장용 스트림 객체 생성
			bout = new BufferedOutputStream(new FileOutputStream(saveFile));
			
			//Socket으로 수신(읽기)한 데이터를 파일로 출력하기
			byte[] temp = new byte[1024];
			int length = 0;
			while((length=bin.read(temp))!=-1) {
				bout.write(temp,0,length);
			}
			bout.flush();
			
			System.out.println("파일 저장 완료...");
			
		}catch(Exception e) {
			System.out.println("파일 수신 작업 실패");
		}finally {
			//사용했던 스트림과 소켓 닫기.
			if(din!=null) try { din.close();} catch(IOException e) {};
			if(bin!=null) try { bin.close();} catch(IOException e) {};
			if(bout!=null) try { bout.close();} catch(IOException e) {};
			if(socket!=null) try {socket.close();} catch(IOException e) {};
			if(server!=null) try {server.close();} catch(IOException e) {};
		}
	}
}
