package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 큐 사이즈만큼 돌려서 cnt++
public class baek벽 {

	// cuush가 0이면 벽 부수기 가능, 1이면 부수는 능력 다 씀
	static class Node {
		int r, c, crush;

		Node(int r, int c, int crush) {
			this.r = r;
			this.c = c;
			this.crush = crush;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = (str.charAt(j) - 48);
			}
		}

		// 벽 부시지 않았을 때 방문체크
		boolean[][] wall1 = new boolean[n][m];

		// 벽 부셨을 때 방문체크
		boolean[][] wall0 = new boolean[n][m];

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		Queue<Node> q = new LinkedList<>();
		wall1[0][0] = true;
		q.add(new Node(0, 0, 0));
		int cnt = 1;
		int ans = -1;
		
		loop:
		while (!q.isEmpty()) {
			int size = q.size();
			for (int a = 0; a < size; a++) {
				Node node = q.poll();

				if (node.r == n - 1 && node.c == m - 1) {
					ans = cnt;
					break loop;
				}

				for (int d = 0; d < 4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];

					if (nr < 0 || nc < 0 || nr >= n || nc >= m)
						continue;
					
					// 벽이 없을 때
					if (map[nr][nc] == 0) {
						if (node.crush == 0) {
							if (!wall1[nr][nc]) {
								wall1[nr][nc] = true;
								q.add(new Node(nr, nc, 0));
							}
						} else {
							if (!wall0[nr][nc]) {
								wall0[nr][nc] = true;
								q.add(new Node(nr, nc, 1));
							}
						}
					}
					// 벽이 있을 때
					else {
						if (node.crush == 0) {
							wall0[nr][nc] = true;
							q.add(new Node(nr, nc, 1));
						}
					}
				}
			}
			cnt++;
		}

		System.out.println(ans);

	} // main

}
