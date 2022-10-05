package baekjoon;

import java.util.Scanner;

public class baek신기한수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		for(int num = 1; num <= n; num++) {
			int sum = 0;
			int nn = num;
			while( nn>0 ) {
				int a = nn%10;
				nn = nn/10;
				sum += a;
			}
			
			if(num%sum == 0) {
				cnt++;
			}
		}

		System.out.println(cnt);
	} //main

}
