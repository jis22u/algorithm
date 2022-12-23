package 구현;

// 어우 나중에 다시
import java.util.Scanner;

public class Main {

	static char[] QUACK = {'q','u','a','c','k'};
	static int duck;
	public static void main(String[] args) {
		// q 오리수
		// quack
		// 오리 소리가 맞니? 순서 유지 하는지
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();	
		int len = arr.length;
		sc.close();

		duck = 0; 
		// 문자열의 길이가 5의 배수가 아니면 -1
		if(arr.length%5 != 0) {
			duck = -1; 
		} else {
			isDuck(arr);
		}
		
		System.out.println(duck);
	} // main
	
	static void isDuck(char[] arr) {
		int remain = arr.length;
		
		while(remain != 0) {
			
		}
		
	}
}
