package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전기버스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			// K 최대 이동 수, N 종점 번호, M 충전기 설치된 정류장 개수
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 충전기 있으면 true
			boolean[] charge = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				charge[Integer.parseInt(st.nextToken())] = true;
			}

			boolean[] visited = new boolean[n+1];
			int i = 0;
			int cnt = 0;
			int go = k;
			loop:
			while (i <= n) {
				go--;
				i++;
				
				if(i == n) break;
				
				if (go <= 0) {
					if (charge[i] == true) {
						go = k;
						cnt++;
					} else {
						int idx = 0;
						outter: 
						for (int j = i; j >= 0; j--) {
							if (charge[j] == true) {
								if(!visited[j]) {
									idx = j;
									visited[j] = true;
									break outter;
								} else {
									cnt = 0;
									break loop;
								}
							}
						}
						i = idx;
						go = k;
						cnt++;
					}
				}
			}

			System.out.println("#"+t+" "+cnt);

		}
	} // main

}
