package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();
	}
	//시작 매서드
	public void clientStart() {
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.142.5",7777);
			System.out.println("서버에 연결 되었습니다.");
			
			//메시지 전송용 쓰레드 생성
			ClientSender sender = new ClientSender(socket);
			
			//메시지 수신용 쓰레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			sender.start();
			receiver.start();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}//시작 매서드 끝
	
	//메시지 전송용 쓰레드 작성
	class ClientSender extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;
		
		private String name;
		private Scanner scan;
		
		
		public ClientSender(Socket socket) {
			scan = new Scanner(System.in);
			this.socket = socket;
			
			try {
				din = new DataInputStream(socket.getInputStream());
				dout = new DataOutputStream(socket.getOutputStream());
				
				if(dout!=null) {
					while(true) {
						//클라이언트가 대화명을 입력받아 서버로 전송하고
						//서버에서 '대화명'의 중복여부를 응답으로 받아서 확인한다.
						System.out.println("대화명 >>");
						
						String name = scan.nextLine();
						
						dout.writeUTF(name); // 대회명 전송
						
						// 대화명의 중복 여부를 응답으로 받는다.
						
						String feedBack = din.readUTF();
						
						if(feedBack.equals("대화명중복")) { // 이름이 중복될때
							System.out.println("입력한 이름은 이미 사용중인 이름입니다.");
							System.out.println("다른 대화명을 입력하세요.");
							
						}else { // 이름이 중복되지 않을때
							this.name = name;
							System.out.println("["+name + "] 대화명으로 대화방에 입장했습니다.");
							break; // 반복문 탈출
						}
					}// while문의 끝..
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//생성자 끝
		
		@Override
		public void run() {
			try {
				while(dout!=null) {
					//키보드로 입력한 내용을 서버로 전송한다.
					dout.writeUTF("["+name+"]"+scan.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				din=new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		@Override
		public void run() {
			while(din!=null) {
				try {
					System.out.println(din.readUTF());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
		
	}
	
	
}
