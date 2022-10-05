package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[n][3];
		int[][] dp = new int[2][3];
		StringTokenizer st;
		for(int i = 0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 일단 이전 최적해를 초기값으로 설정
		dp[0][0] = rgb[0][0];
		dp[0][1] = rgb[0][1];
		dp[0][2] = rgb[0][2];
		
		for(int i=1; i<n; i++) {
			// 새로운 최적해
			dp[1][0] = Math.min(dp[0][1], dp[0][2]) + rgb[i][0]; 
			dp[1][1] = Math.min(dp[0][0], dp[0][2]) + rgb[i][1]; 
			dp[1][2] = Math.min(dp[0][0], dp[0][1]) + rgb[i][2];
			
			// 이전 최적해로 옮겨주기
			dp[0][0] = dp[1][0];
			dp[0][1] = dp[1][1];
			dp[0][2] = dp[1][2];
		}
		
		int min = Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
		System.out.println(min);
	}

}
