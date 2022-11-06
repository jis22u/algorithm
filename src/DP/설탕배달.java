package DP;

import java.util.Scanner;

public class 설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] memo = new int[n+3];
		memo[1] = -1;
		memo[2] = -1;
		memo[3] = 1;
		memo[4] = -1;
		memo[5] = 1;
		
		for(int i=6; i<=n; i++) {
			if(memo[i-3]==-1 && memo[i-5]==-1) {
				memo[i] = -1;
				continue;
			}
			
			int min=0;
			if(memo[i-3]==-1) {
				min = memo[i-5];
			} else if(memo[i-5]==-1) {
				min = memo[i-3];
			} else {
				min = Math.min(memo[i-3], memo[i-5]);
			}
			memo[i]= min+1;
		}
		System.out.println(memo[n]);
	
	
	} // main

}
