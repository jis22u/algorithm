package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class TTT {

	public static void main(String[] args) {
		// 1. StringBuilder 공백 인정
		StringBuilder sb = new StringBuilder();
		
		sb.append('b');
		sb.append(' ');
		sb.append('b');
		
		System.out.println(sb);
		
		
		// 2. 문자열 쪼개어 받기
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		//A01B02C03
		
		for(int i=0; i<str.length(); i += 3) {
			String a = str.substring(i, i+3);
			System.out.println(a);
		}
		
		// 3. toCharArray() 를 이렇게도 쓸 수 있구나
		char[] parts = (""+0+1).toCharArray();
		System.out.println(parts[0]+" "+parts[1]);
		
	}

}
