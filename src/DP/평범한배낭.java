package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 백준 12865
public class 평범한배낭 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		// <작은 부분 문제 해결해가면서 최종 최적해 구하기>
		// 모든 아이템에 대해서 모든 K그램 배낭에 대해
		// 가능한 모든 물건의 가치를 구하겠다.
		// dp배열에 저장하면서 가장 마지막 행의 마지막 열에서
		// 모든 경우의 최적해가 결정된다.
		int[][] dp = new int[N+1][K+1];
		for(int item=1; item<N+1; item++) {
			for(int k=0; k<=K; k++) {
				if(weight[item]<=k) {
					dp[item][k] = Math.max(dp[item-1][k], dp[item-1][k-weight[item]]+value[item]);
				} else {
					dp[item][k] = dp[item-1][k];
				}
			}
		}
		
		System.out.println(dp[N][K]);
		br.close();
	} //main

}
