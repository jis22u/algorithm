package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1961 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n;
		int[][] arr;
		StringBuilder sb;
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			// 배열에 넣기
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			tc 1.
//			arr[2][0]   arr[2][2]	arr[0][2]
//			arr[1][0]   arr[2][1]	arr[1][2]
//			arr[0][0]   arr[2][0]	arr[2][2]
//			0,0			0,1			0,2
//			
//			arr[2][1]	arr[1][2]	arr[0][1]
//			arr[1][1]	arr[1][1]	arr[1][1]
//			arr[0][1]	arr[1][0]	arr[2][1]
//			1,0			1,1			1,2
//					
//			arr[2][2]	arr[0][2]	arr[0][0]
//			arr[1][2]	arr[0][1]	arr[1][0]
//			arr[0][2]	arr[0][0]	arr[2][0]
//			2,0			2.1			2,2
									
			sb = new StringBuilder();
			StringBuilder[][] ans = new StringBuilder[n][3];
			sb.append("#"+t+"\n");
			for (int i = 0; i < n; i++) { 
					for (int k = 0; k < n; k++) {
						sb.append(arr[n - 1 - k][i]);
					}
					sb.append(" ");
					
					for (int k = n-1; k >= 0; k--) {
						sb.append(arr[n-1-i][k]);
					}
					sb.append(" ");
					for (int k = 0; k < n; k++) {
						sb.append(arr[k][n-1-i]);
					}
					sb.append("\n");
			}
			System.out.print(sb);
		}


	} // main

}
