package kr.or.ddit.basic.args;

/*
 	가변인자  : 매서드의 인자의 갯수가 실행될때마다 다를때 사용한다.
 	
 	- 가변인자는 매서드 안에서 배열로 처리가 된다.
 	- 가변인자는 매서드에서 한개만 사용할수있다.
 	
 */

public class ArgsTest {
	//매개변수로 받은 정수들의 합계를 구하는 매서드 만들기.
	//	이 정수의 갯수는 상황에따라 달라질수있다.
	
	//배열을 이용한 매서드.
	public int sumArr(int[] data) {
		int sum = 0;
		for(int num : data) {
			sum+=num;
		}
		return sum;
	}
	
	//가변인자를 이용한 매서드
	public int sumArg(int... data) {
		
		int sum = 0;
		for(int num : data) {
			sum+=num;
		}
		return sum;
	}
	
	//가변인자와 일반 매개변수를 같이 사용할경우에는 가변인자를 제일 뒤쪽에 배치해야한다.
	public String sumArg2(String name , int... data) {
		
		int sum = 0;
		for(int num : data) {
			sum+=num;
		}
		return name + "씨 점수 : "+sum;
	}
	
	
	
	public static void main(String[] args) {
		ArgsTest test = new ArgsTest();
		
		int[] numArr = {100,200,300};
		System.out.println(test.sumArr(numArr));
		System.out.println(test.sumArr(new int[] {1,2,3,4,5}));
		
		System.out.println(test.sumArg(100,200,300));
		System.out.println(test.sumArg(1,2,3,4,5));
		
		System.out.println(test.sumArg2("나성진", 100,200,300));
		System.out.println(test.sumArg2("나호진", 1,2,3,4,5));
		
	}
}
