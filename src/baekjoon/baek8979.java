package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek8979 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 각 나라별 메달 정보
		int[][] medal = new int[n+1][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			medal[idx][0] = g;
			medal[idx][1] = s;
			medal[idx][2] = b;
		}
                                
		
		// 내 앞에 있는 나라
		int cnt = 0;
		// 랭킹 정해진 나라 & 나보다 아래 순위인 나라 체크
		boolean[] rank = new boolean[n+1];
		for (int j = 0; j < 3; j++) {
			for (int i = 1; i < n+1; i++) {
				if (i!=k && !rank[i] && medal[k][j] < medal[i][j]) {
					rank[i] = true;
					cnt++;
				} else if(i!=k && !rank[i] && medal[k][j] > medal[i][j]) {
					rank[i] = true;
				}
			}
		}

		System.out.println(cnt+1);
		br.close();
	} // main

}
