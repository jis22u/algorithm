package 문자열;

import java.util.Scanner;

public class 문자열_백준 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		int pointer = B.length() - A.length();
		int cnt = 0;
		int min = Integer.MAX_VALUE;;
		for(int j=0; j<=pointer; j++) {
			for(int i=0; i<A.length(); i++) {
				if(A.charAt(i) != B.charAt(i+j)) {
					cnt++;
				}
			}
			min = Math.min(min, cnt);
			cnt=0;
		}
		
		System.out.println(min);
	}

}
