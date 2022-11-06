package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1260
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고
// 위의 조건 때문에 PriorityQueue를 사용했지만 이는 BFS에 적합하지 않은 자료구조
// 계속해서 오름차순으로 정렬하면서 정점들을 저장하기 때문에 작은 정점들만 먼저 방문하게 된다.
public class DFS와BFS {

	static int[][] map;
	static int N, M;
	static boolean[] visited;
	static List<Integer> list;
	static Queue<Integer> p;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		int V = Integer.parseInt(stz.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			stz = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stz.nextToken());
			int ed = Integer.parseInt(stz.nextToken());
			map[st][ed] = 1;
			map[ed][st] = 1;
		}
		
		// DFS
		list = new ArrayList<>();
		visited = new boolean[N+1];
		dfs(V);
		
		StringBuilder sb = new StringBuilder();
		for(int a : list) {
			sb.append(a+" ");
		}
		sb.delete(sb.length()-1, sb.length());
		
		System.out.println(sb);
		
		// BFS
		p =  new LinkedList<>();
		list = new ArrayList<>();
		visited = new boolean[N+1];
		p.add(V);
		list.add(V);
		visited[V]=true;
		bfs(V);
		
		StringBuilder sb2 = new StringBuilder();
		for(int a : list) {
			sb2.append(a+" ");
		}
		sb2.delete(sb2.length()-1, sb2.length());
		
		System.out.println(sb2);
	} // main

	
	static void dfs(int stV) {
		if(visited[stV]) return;
		
		list.add(stV);
		visited[stV] = true;
		
		for(int j=1; j<N+1; j++) {
			if(map[stV][j] == 1) {
				dfs(j);
			}
		}
	}
	
	
	static void bfs(int stV) {
		while(!p.isEmpty()) {
			int now = p.poll();
			
			for(int j=1; j<N+1; j++) {
				if(map[now][j]==1 && !visited[j]) {
					visited[j] = true;
					p.add(j);
					list.add(j);
				}
			}
		}
	}
}