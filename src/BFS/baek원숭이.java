package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek원숭이 {

	// k는 말처럼 움직일 수 있는 능력
	static class Monkey {
		int r, c, k, cnt;

		Monkey(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][] map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][][] visited = new boolean[K+1][h][w];

		// 원숭이처럼
		int[] mr = { -1, 0, 1, 0 };
		int[] mc = { 0, 1, 0, -1 };

		// 말처럼
		int[] hr = { -2, -1, 1, 2, -2, -1, 2, 1 };
		int[] hc = { 1, 2, 2, 1, -1, -2, -1, -2 };

		Queue<Monkey> q = new LinkedList<>();
		// 방문체크하고 큐에 삽입
		visited[0][0][0] = true;
		q.add(new Monkey(0, 0, 0, 0));

		int ans = -1;
		while (!q.isEmpty()) {
			Monkey m = q.poll();

			if (m.r == h - 1 && m.c == w - 1) {
				ans = m.cnt;
				break;
			}

			if (m.k == K) {
				// 말처럼 움직일 수 있는 능력 다 씀
				for (int d = 0; d < 4; d++) {
					int monkeyR = m.r + mr[d];
					int monkeyC = m.c + mc[d];

					if (monkeyR < 0 || monkeyC < 0 || monkeyR >= h || monkeyC >= w)
						continue;

					if (visited[m.k][monkeyR][monkeyC])
						continue;

					if (map[monkeyR][monkeyC] == 0) {
						visited[m.k][monkeyR][monkeyC] = true;
						q.add(new Monkey(monkeyR, monkeyC, m.k, m.cnt + 1));
					}
				}
			} else {
				// 말처럼 움직일 수 있음
				for (int d = 0; d < 8; d++) {
					int horseR = m.r + hr[d];
					int horseC = m.c + hc[d];

					if (horseR < 0 || horseC < 0 || horseR >= h || horseC >= w)
						continue;

					if (visited[m.k + 1][horseR][horseC])
						continue;

					if (map[horseR][horseC] == 0) {
						visited[m.k + 1][horseR][horseC] = true;
						q.add(new Monkey(horseR, horseC, m.k + 1, m.cnt + 1));
					}
				}
				
				for (int d = 0; d < 4; d++) {
					int monkeyR = m.r + mr[d];
					int monkeyC = m.c + mc[d];
					
					if (monkeyR < 0 || monkeyC < 0 || monkeyR >= h || monkeyC >= w)
						continue;
					
					if (visited[m.k][monkeyR][monkeyC])
						continue;
					
					if (map[monkeyR][monkeyC] == 0) {
						visited[m.k][monkeyR][monkeyC] = true;
						q.add(new Monkey(monkeyR, monkeyC, m.k, m.cnt + 1));
					}
				}
			}
		}

		System.out.println(ans);
	}
}
