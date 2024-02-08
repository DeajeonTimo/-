package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // 4개짜리 byte 배열 생성
		
		//입출력용 스트림 객체 생성
		ByteArrayInputStream bin = new ByteArrayInputStream(inSrc);
		
		//출력용 스트림 객체 생성
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		try {
			//읽어올 데이터가 있는지 확인
			while(bin.available()>0) {
				bin.read(temp);
				System.out.println("temp => " + Arrays.toString(temp));
				bout.write(temp);
				System.out.println(" outSrc => " + Arrays.toString(outSrc));
				bin.read(temp);
				
//				int len = bin.read(temp);
//				bout.write(temp,0,len);
				System.out.println("temp => " + Arrays.toString(temp));
				
				outSrc = bout.toByteArray();
				System.out.println(" outSrc => " + Arrays.toString(outSrc));
				System.out.println(" inSrc => " + Arrays.toString(inSrc));
				bin.close();
				bout.close();

			}
		}catch (IOException e) {
			
		}
	}
}
