package DFS;

import java.util.*;
import java.io.*;

public class 촌수계산 {

	static int n,m,x,y,res;
	static int[][] graph;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정점의 개수
		n = Integer.parseInt(br.readLine());
		// 찾고자 하는 정점들
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		// 간선의 개수
		m = Integer.parseInt(br.readLine());
		
		// 인접행렬로 정점들 간의 인접상태 표현
		graph = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[p][c] = graph[c][p] = 1;
		}
		
		// 방문했던 정점 체크
		check = new boolean[n+1];
		
		res = -1;
		check[x] = true;
		dfs(x,0);
		
		System.out.println(res);
	}

	static void dfs(int idx, int ans) {
		if(idx == y) {
			res = ans;
			return;
		}
		
		for(int i=1; i<n+1; i++) {
			if(graph[i][idx] == 1 && !check[i]) {
				check[i] = true;
				dfs(i, ans+1);
			}
		}
	}
}
