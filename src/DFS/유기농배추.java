package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 백준 유기농 배추
public class 유기농배추 {

	static int[][] map;
	static int M,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			int cnt = 0;
			for(int i=0; i<M; i++ ) {
				for( int j=0; j<N; j++) {
					if(map[i][j] == 1) {
						cnt++;
						map[i][j] = 0;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
	} // main
	
	static int[] dr = {1,-1,0,0}; 
	static int[] dc = {0,0,1,-1};
	static void dfs(int i, int j) {
		
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr<0 || nc<0 || nr>=M || nc>=N) continue;
			if(map[nr][nc] == 0) continue;

			map[nr][nc] = 0;
			dfs(nr,nc);
		}
	}
}
