package kr.or.ddit.basic;

import java.io.Serializable;

public class Member implements Serializable{

	// transient : 해당 키워드가 붙은 멤버 변수는 직렬화 대상에서 제외된다.
	private String name;
	private  int age;
	private transient String addr;
	
	
	public Member(String name, int age, String addr) {
		
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
