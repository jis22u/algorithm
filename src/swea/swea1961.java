package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1961 {

	static int n;
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

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

			
			String[][] ans = new String[n][3];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					ans[i][0] = first(n-1, j);
					ans[i][1] = second(n-1-j, n-1);
					ans[i][2] = third(0, n-1-j);
				}
			}
			
			sb = new StringBuilder();
			for(int j =0; j<3; j++) {
				for(int i =0; i<n; i++) {
					sb.append(ans[i][j]+" ");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("\n");
			}
			
			System.out.println("#"+t+"\n"+sb);
		}

	} // main

	static String first(int a, int b) {
		sb = new StringBuilder();
		for (int i = a; i >= 0; i--) {
			sb.append(arr[i][b]);
		}
		return sb.toString();
	}

	static String second(int b, int a) {
		sb = new StringBuilder();
		for (int i = a; i >= 0; i--) {
			sb.append(arr[b][i]);
		}
		return sb.toString();
	}

	static String third(int a, int b) {
		sb = new StringBuilder();
		for (int i = a; i < n; i++) {
			sb.append(arr[i][b]);
		}
		return sb.toString();
	}

}
