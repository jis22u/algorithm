package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek2422 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[][] check = new boolean[n+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			check[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		
		int cnt = 0;
		int ans = 0;
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
			
			}
		}
		
		System.out.println(ans);
        br.close();
		
	} //main

}
