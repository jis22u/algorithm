package DP;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class 피보나치 {
	static BigInteger ori;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 순수 피보나치
//		System.out.println("fibo1(): "+fibo1(n)+" "+ callCnt1);

		// 메모이제이션
//		memo = new long[n+1];
//		Arrays.fill(memo, -1);
//		memo[0] = 0;
//		memo[1] = 1;
//		System.out.println("fibo2(): "+fibo2(n)+" "+ callCnt2);
		
		
		// 상향식으로 구현
		dp = new BigInteger[n+2];
		ori = new BigInteger("-1");
		Arrays.fill(dp, ori);
//		dp[0] = new BigInteger("0");
//		dp[1] = new BigInteger("1");
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		
		System.out.println(fibo3(n));
	} // main

	// 순수 피보나치 수열
//	static int callCnt1;
//	static int fibo1(int n) {
//		callCnt1++;
//		
//		if(n<2) {
////			System.out.println("fibo1("+n+") 호출"); 
//			return n;
//		}
//		
//		int a = n-1;
//		int b = n-2;
////		System.out.println("fibo1("+a+") "+"fibo1("+b+") 호출");
//		return fibo1(n-2) + fibo1(n-1);
//	}
	
	
	// 메모이제이션 활용_재귀함수 기반
//	static long[] memo;
//	static int callCnt2;
//	static long fibo2(int n) {
//		callCnt2++;
//		if(memo[n] == -1) {
//			memo[n] = fibo2(n-2) + fibo2(n-1);
//		}
//		return memo[n];  
//	}
	
	// 상향식으로 구현_반복문
	static BigInteger[] dp;
	static BigInteger fibo3(int n) {
		if(dp[n].compareTo(ori) == 0) {
			for(int i = 2; i<=n; i++) {
				dp[i] = dp[i-2].add(dp[i-1]);
			}
		}
		return dp[n];
	}
}
