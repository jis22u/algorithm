package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
	
//	static boolean[][] visited;			// 필요없음
	static int R,C, cnt, max;
	static boolean[] alpha;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new boolean[26];
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray(); 
		}
		
		max = 1;
		cnt = 1;
		alpha[map[0][0] -'A'] = true;
		dfs(0,0);
		System.out.println(max);
		
	} //main
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static void dfs(int i, int j) {
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
			if(alpha[map[nr][nc] -'A']) continue;
			
			alpha[map[nr][nc] -'A'] = true;
			cnt++;
			
			dfs(nr,nc);
			
			max = Math.max(max, cnt);
			cnt--;
			alpha[map[nr][nc] -'A'] = false;
		}
	}
}
