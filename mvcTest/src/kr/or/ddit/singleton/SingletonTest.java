package kr.or.ddit.singleton;

public class SingletonTest {

	public static void main(String[] args) {
//		MySingleton test1 = new MySingleton();
		
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println();
		System.out.println("test2 ==>" +test2);
		System.out.println("test3 ==>" +test3);
		System.out.println();
		
		System.out.println(test2==test3);
		System.out.println(test2.equals(test3));
	}
}
