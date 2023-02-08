package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
	static int N,L,R;
	static int[][] map;
	static boolean[][] union;
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// 인구 수 저장
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		while(true) {
			// 연합 여부 표시
			union = new boolean[N][N];
			// 연합 나라 수
			boolean flag = false;

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!union[i][j]) {
						if (bfs(i,j) >= 2) {
							flag = true;
						}
					}
				}
			}

			// 그냥 cnt == 1 로 판단하면 안되는 이유
			//     앞부분에서 연합이 이루어지고 뒷부분에서 연합이 안이루어진 경우가 있음
			// 더이상 인구이동이 일어나지 않았다
			if (!flag) {
				break;
			}

			day++;
		}

		System.out.println(day);

	}

	// 사방으로 인구차이 구하고 연합여부 판단
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int bfs (int r, int c) {
		// 연합 나라 수
		int cnt = 1;
		// 연합하는 나라 저장
		Queue<Node> unionCC = new LinkedList<>();
		// bfs 계산용
		Queue<Node> CC = new LinkedList<>();
		// 연합인구수 합
		int sum = map[r][c];
		// 초기화
		CC.add(new Node(r,c));
		unionCC.add(new Node(r,c));
		union[r][c] = true;

		// 인구이동하면서 sum cnt 구하기
		while(!CC.isEmpty()) {
			Node node = CC.poll();

			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];

				if (nr >= N | nc >= N | nr < 0 | nc < 0) {continue;}
				if (union[nr][nc]) {continue;}
				if (Math.abs(map[node.r][node.c] - map[nr][nc]) >= L && Math.abs(map[node.r][node.c] - map[nr][nc]) <= R) {
					union[nr][nc] = true;
					unionCC.add(new Node(nr, nc));
					CC.add(new Node(nr, nc));
					sum += map[nr][nc];
					cnt++;
				}
			}
		}

		if(cnt == 1) {
			// 인구이동이 일어나지 않음
			return 1;
		} else {
			// 값 대입
			while(!unionCC.isEmpty()) {
				Node node = unionCC.poll();
				map[node.r][node.c] = sum/cnt;
			}
		}
		return cnt;
	}
}
