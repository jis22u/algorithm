package baekjoon;

import java.util.Scanner;

// 팰린드롬수
public class baek1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String num = sc.next();
			int len = num.length();
			
			if(num.equals("0")) break;
			
			String ans = "yes";
			for(int i=0; i<len; i++) {
				char a = num.charAt(i);
				char b = num.charAt(len-i-1);
				if(a != b) ans = "no";
			}
			System.out.println(ans);
		}
	}

}
