package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정답이 되는 경우가 언제야? (규칙 발견)
// 1찾고 그 이후에 2가 나오면 cnt++
// swea 1220
public class Magnetic {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 0; i < 100; i++) {
				fo: for (int j = 0; j < 100; j++) {
					if (arr[j][i] == 1) {
						while (true) {
							j++;
							if (j >= 100) break;
							if (arr[j][i] == 2) {
								cnt++;
								continue fo;
							}
						}
					}
				}
			}

			System.out.println("#" + t + " " + cnt);
		}

	} // main

}
