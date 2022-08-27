package baekjoon;

import java.util.Scanner;


// 암호화된 문자를 해독하기....
// 거꾸로 올라가기
public class baek2999 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int len = str.length();
		
		// 행열 숫자
		int r =0;
		int c =0;
		for(int i=1; i<=len; i++) {
			for(int j=len; j>=1; j--) {
				if(i<=j && i * j == len) {
					r = i;
					c = j;
				}
			}
		}
		
		// 처음 시도해본 방식
		int k =0;
		char[][] arr = new char[r][c];
		for(int j=0; j<c; j++) {
			for(int i=0; i<r; i++) {
				arr[i][j] = str.charAt(k++);
			}
		}

		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				sb.append(arr[i][j]);
			}
		}
		
		System.out.println(sb);
		sc.close();
	} //main

}
