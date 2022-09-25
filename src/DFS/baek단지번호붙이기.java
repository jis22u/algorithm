package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek단지번호붙이기 {

	static int n;
	static int[][] map;
	static int[][] home;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		home = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = (str.charAt(j) - 48);
			}
		}

		// 단지 개수
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					cnt++;
					dfs(i, j, cnt);
				}
			}
		}

		// 단지 내 집 개수
		int[] tmp = new int[cnt + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (home[i][j] == 0) {
					continue;
				}

				for (int k = 1; k <= cnt; k++) {
					if (home[i][j] == k) {
						tmp[k]++;
					}
				}
			}
		}

		Arrays.sort(tmp);

		System.out.println(cnt);
		for (int i = 1; i <= cnt; i++) {
			System.out.println(tmp[i]);
		}

	} // main

	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static void dfs(int r, int c, int cnt) {
		map[r][c] = 0;
		home[r][c] = cnt;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
				continue;
			}

			if (map[nr][nc] == 0) {
				continue;
			} else {
				dfs(nr, nc, cnt);
			}

		}

	}

}
