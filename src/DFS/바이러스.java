package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {

	static int N;
	static int[][] map;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		
		StringTokenizer stz;
		for(int i=0; i<M; i++) {
			stz = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stz.nextToken());
			int ed = Integer.parseInt(stz.nextToken());
			map[st][ed] = map[ed][st] = 1;
		}
		
		dfs(1);
		
		int cnt = 0;
		for(int i=2; i<=N; i++) {
			if(check[i]) cnt++;
		}
		
		System.out.println(cnt);
	} // main
	
	static void dfs(int i) {
		if(check[i]) return;
		
		check[i] = true;
		
		for(int j=1; j<=N; j++) {
			if(map[i][j] == 1) {
				map[i][j] = 0;
				dfs(j);
			}
		}
	}
}
