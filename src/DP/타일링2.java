package DP;

import java.util.Scanner;

public class 타일링2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+2];
		dp[0] = 0;  
		dp[1] = 1;
		dp[2] = 3;
		if(n>2 && dp[n] == 0) {
			for(int i=3; i<=n; i++) {
				dp[i] = dp[i-2] * 2 + dp[i - 1];
				dp[i] %= 10007;
			}
		}
		
		System.out.println(dp[n]);
	} // main

}
