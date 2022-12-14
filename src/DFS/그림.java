package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그림 {

	static int n,m, max, area;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		area = 0;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					cnt++;
					area=0;
					dfs(i,j);
					max = Math.max(max, area);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	} //main
	
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static void dfs(int i, int j) {
		map[i][j] = 0;
		area++;
		
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr>=n || nc>=m || nr<0 || nc<0) continue;
			if(map[nr][nc] == 0) continue;
			
			dfs(nr,nc);
		}
		
		
	}

}
