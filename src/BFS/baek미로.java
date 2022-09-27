package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek미로 {

	static class Node {
		int r, c, cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] visited = new boolean[n + 2][m + 2];
		int[][] map = new int[n + 2][m + 2];
		for (int i = 1; i < n + 1; i++) {
			String str = br.readLine();
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = (str.charAt(j - 1) - 48);
			}
		}


		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 1, 1));
		visited[1][1] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.r == n && node.c == m) {
				System.out.println(node.cnt);
				break;
			}

			for (int k = 0; k < 4; k++) {
				int nr = node.r + dr[k];
				int nc = node.c + dc[k];

				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					q.add(new Node(nr, nc, node.cnt+1));
					visited[nr][nc] = true;
				}
			}

		}


//		for (int i = 0; i < n + 2; i++) {
//			for (int j = 0; j < m + 2; j++) {
//				System.out.print(visited[i][j]);
//			}
//			System.out.println();
//		}

	} // main

}