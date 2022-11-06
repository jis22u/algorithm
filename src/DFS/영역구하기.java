package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// 백준 영역 구하기 2583
public class 영역구하기 {

	static boolean[][] map;
	static int M, N, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new boolean[M][N];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					map[i][j] = true;
				}
			}
		}

		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j]) {
					cnt = 1;
					map[i][j] = true;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		Collections.sort(list);

		sb.append(size).append("\n");
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.print(sb.delete(sb.length() - 1, sb.length()).toString());

	} // main

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static void dfs(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];

			if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
			if (map[nr][nc]) continue;

			cnt++;
			map[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}
