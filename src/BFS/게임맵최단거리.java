package BFS;

import java.util.*;

// 프로그래머스
public class 게임맵최단거리 {
	// 한칸을 Node로 표현, cnt는 이동한 칸의 개수
	static class Node {
		int i, j, cnt;

		Node(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 } };
		
		// n과 m 구하기
		int n = maps.length;
		int m = maps[0].length;
		
		// 방문한 곳은 체크해서 다시 방문하지 않도록 한다.
		boolean[][] visited = new boolean[n][m];
		
		// 방문한 Node 저장
		Queue<Node> queue = new LinkedList<>();

		// 1,1 부터 시작. 큐에 담아주고 방문처리
		// 배열 상에서는 0,0부터 시작
		queue.add(new Node(0, 0, 1));
		visited[0][0] = true;

		// 동서남북으로 이동 가능
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int answer = -1;
		
		// 큐에 담겨진 Node에서 다음 움직일 수 있는 곳 찾기
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (node.i == n-1 && node.j == m-1) {
				answer = node.cnt;
				break;
			}

			// 일단 동서남북 모두 탐색
			for (int d = 0; d < 4; d++) {
				int nr = node.i + dr[d];
				int nc = node.j + dc[d];

				// 맵 밖으로 나가면 이동 불가
				if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
				// 이동하려는 곳이 0이면, 벽이면 이동 불가
				if (maps[nr][nc] == 0) continue;
				// 이미 방문했던 곳도 이동 불가
				if (visited[nr][nc]) continue;

				// 큐에 담고 방문 처리
				visited[nr][nc] = true;
				queue.add(new Node(nr, nc, node.cnt+1));
				
			}
		}

		System.out.println(answer);

	} // main

}
