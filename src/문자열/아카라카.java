package 문자열;

import java.util.Scanner;

public class 아카라카 {

	static String ans;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ans = "IPSELENTI";
		
		// 문자열 자체가 팰린드롬인지
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		if(str.equals(sb.reverse().toString())) {
			recur(str);
		}
		
		System.out.println(ans);
	}
	
	static void recur (String target) {
		int len = target.length();
		if(len == 1) {
			ans = "AKARAKA";
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		int lenhalf = len/2;
		String front = target.substring(0, lenhalf);
		String rear = target.substring(len-lenhalf, len);
		
		// 접두사, 접미사가 다르면 아카라카가 아님
		if(!front.equals(rear)) {
			ans = "IPSELENTI";
			return;
		}
		
		// 같으면 둘 중 하나만 알아봐도 됨
		sb.append(front);
		if(front.equals(sb.reverse().toString())) {
			recur(front);
		}
	}
}
