package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음식물피하기 {

	static int[][] map;
	static int N,M,ans,size;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수
		ans = Integer.MIN_VALUE;

		map = new int[N+1][M+1];
		int r = 0; // 음식물이 떨어진 좌표 r,c
		int c = 0;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;		// 음식물이 있는 좌표는 1
		}

		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				if(map[i][j] == 1) {
					map[i][j] = 0;
					size = 1;
					dfs(i, j);
				}
				if(ans < size) {
					ans = size;
				}
			}
		}
		System.out.println(ans);
	}

	static int[] dr = {-1,0,1,0}; // 4방으로 인접
	static int[] dc = {0,1,0,-1};
	static void dfs(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if(nr>=N+1 || nc>=M+1 || nr<0 || nc<0) continue;
			if(map[nr][nc] == 0) continue;

			map[nr][nc] = 0;
			size++;
			dfs(nr, nc);
		}
	}
}
