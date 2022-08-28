package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


// 규칙성 발견
// 반복문으로 표현해서 컴퓨터에 반복작업 시키기

// 농작물 수확하기
public class swea2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] farm = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<n; j++) {
					farm[i][j] = str.charAt(j)-48;
				}
			}
			
			// 위 삼각형
			int k = n/2;
			int sum=0;
			for(int i=0; i<=k; i++) {
				for(int j=k-i; j<=k+i; j++) {
					sum += farm[i][j];
				}
			}
			
			// 아래 삼각형 
			for(int i=k+1; i<n; i++) {
				for(int j=i-k; j<n+k-i; j++) {
					sum += farm[i][j];
				}
			}
			
			bw.append("#"+t+" "+sum);
			bw.flush();
			bw.newLine();
		}
		bw.close();
		br.close();
		
		
	} //main

}
