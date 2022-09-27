package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek토마토 {

	static class tomato {
		int r, c;

		tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 모두 익은 상태인지 아닌지 판단
		boolean flag = true;

		Queue<tomato> q = new LinkedList<>();
		
		// 입력받기
		int[][] box = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0) {
					flag = false;
				}
				if (box[i][j] == 1) {
					q.add(new tomato(i, j));
				}
			}
		}

		if (flag) {
			System.out.println(0);
		} else {
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			int day = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int a = 0; a < size; a++) {
					tomato t = q.poll();
					for (int k = 0; k < 4; k++) {
						int nr = t.r + dr[k];
						int nc = t.c + dc[k];

						if (nr < 0 || nc < 0 || nr >= n || nc >= m)
							continue;
						if (box[nr][nc] == 1 || box[nr][nc] == -1) {
							continue;
						} else {
							box[nr][nc] = 1;
							q.add(new tomato(nr, nc));
						}
					}
				}
				day++;
			}

			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (box[i][j] == 0) {
						day = 0;
						break loop;
					}
				}
			}

			System.out.println(day - 1);

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(box[i][j]);
//				}
//				System.out.println();
//			}

		}

	} // main

}
