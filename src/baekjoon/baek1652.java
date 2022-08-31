package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek1652 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n + 1][n + 1];

		// 배열 생성
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		
		int cnt = 0;
		int col = 0;
		for(int i=0; i<=n; i++) {
			cnt = 0;
			for(int j=0; j<=n; j++) {
				if (arr[i][j] == '.') {
					cnt++;
				} else {
					if (cnt >= 2) {
						col++;
						cnt = 0;
					}
					cnt = 0;
				}
			}
		}
		
		int row = 0;
		for(int i=0; i<=n; i++) {
			cnt = 0;
			for(int j=0; j<=n; j++) {
				if (arr[j][i] == '.') {
					cnt++;		
				} else {
					if(cnt >= 2) {
						row++;
						cnt=0;
					}
					cnt=0;
				}
			}
		}
		
		
		
		
		// 가로 탐색
//		int cnt = 0;
//		int col = 0;
//		int i = 0;
//		int j = 0;
//		while (i < n && j < n) {
//			if (arr[i][j] == '.') {
//				j++;
//				cnt++;
//			} else {
//				j++;
//				cnt = 0;
//				if (cnt != 1) {
//					col++;
//				}
//			}
//			if (j == n) j=0;i++;
//		}

		// 세로 탐색
//		int row = 0;
//		i = 0;
//		j = 0;
//		while (i < n && j < n) {
//			if (arr[i][j] == '.') {
//				i++;		
//				cnt++;		
//			} else {
//				i++;
//				cnt=0;
//				if(cnt != 1) {
//					row++;
//				}
//			}
//			if(i==n) i=0; j++;
//		}


		System.out.println(col + " " + row);
		br.close();

	} // main

}
