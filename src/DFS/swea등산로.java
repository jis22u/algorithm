package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea등산로 {

	static int[][] map;
	static boolean[][] visited;
	static int n, K;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 가장 높은 봉우리에서 시작
		// 높은 지형> 낮은 지형 (높이 같은 곳 X)
		// 4방 탐색
		// 딱 한번만 1~K깊이만큼 깎을 수 있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			ans = 0;
			visited = new boolean[n][n]; 
			map = new int[n][n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}

			// 최고점에서 시작
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (max == map[i][j]) {
						visited[i][j] = true;
						dfs(i, j, 0, 1, map[i][j]);
						visited[i][j] = false;
					}
				}
			}

			System.out.println("#"+t+" "+ans);

		} // tc
	} // main

	// a : 0이면 K공사 가능, 1이면 K공사 이미 사용
    // height : 변화된 높이값 반영
	static void dfs(int r, int c, int a, int cnt, int height) {
		if (ans < cnt) {
			ans = cnt;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
			if(visited[nr][nc]) continue;
			
			
			if (height <= map[nr][nc]) {
				for(int cc=1; cc<=K ;cc++) {
					if (a==0 && height > map[nr][nc] - cc ) {
						visited[nr][nc] = true;
						dfs(nr, nc, a+1, cnt + 1, map[nr][nc] - cc);
						visited[nr][nc] = false;
					}
				}
			} else {
				visited[nr][nc] = true;
				dfs(nr, nc, a, cnt + 1, map[nr][nc]);
				visited[nr][nc] = false;
			}
			
		}

		
	} // dfs

}
