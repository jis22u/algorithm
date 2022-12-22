package BFS;

// 다익스트라 문제는 bfs로 풀면 정답을 보장할 수 없다...
// bfs로 안 풀림

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지F {
	
	static class Node implements Comparable<Node>{
		int i,j,cost;
		
		Node(int i, int j, int cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cost == o.cost) return o.i-this.i;
			return this.cost - o.cost;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while(true) {
			// 동굴 크기 :N
			int N = Integer.parseInt(br.readLine());
			int[][] cave = new int[N][N];
			
			if(N == 0) break;
			
			// N*N 도둑루피들
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 방문 체크
			boolean[][] visited = new boolean[N][N];
			// 도둑 루피들 담을 pq
			PriorityQueue<Node> pq = new PriorityQueue<>();
			// 하우상좌 순으로 탐색
			// 일단 최단거리로 가는 것이 소지금을 최대한 지키는 것이므로
			int[] dr = {1,0,-1,0};
			int[] dc = {0,1,0,-1};
			
			// 일단 0,0 부터 출발
			pq.add(new Node(0,0,cave[0][0]));
			visited[0][0] = true;
			
			// 총 털린 소지금
			int ans = 0;
			
			// 나머지 탐색 ㄱ
			while(true) {
				Node n = pq.poll();
				ans += n.cost;
//				System.out.println(n.cost);
				
				if(n.i == N-1 && n.j == N-1) {
					break;
				}
				
				for(int d=0; d<4; d++) {
					int nr = n.i + dr[d];
					int nc = n.j + dc[d];
					
					if(nr<0||nc<0||nr>=N||nc>=N) continue; 
					if(visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					pq.add(new Node(nr,nc,cave[nr][nc]));
				}
				
			}
			
//			System.out.println("Problem "+ t++ +": "+ans);
		}
	}

}


// bfs는 시작점에서부터 동일한 거리를 짧은 순서대로 탐색합니다.
// 거리가 1인 곳, 거리가 2인 곳, 거리가 3인 곳 이렇게 촘촘히 검사하지요. 
// 따라서 거리가 3인 곳을 방문할 땐 거리가 2인 곳에서 다시 거리가 1인 곳으로 가지 않습니다.
// 왔던 곳을 다시 가지 않는다는 말입니다.
// 그러나 다익스트라는 왔던 곳을 다시 가기도 합니다. 
// 왔던 곳을 방문하는 더 빠른 최단경로가 존재한다면 말이지요.
// 따라서 알고리즘의 목적 자체가 다른 겁니다. 
// bfs는 모든 곳을 둘러보는 알고리즘이며 다익스트라는 모든 곳에 대해서 방문하는 최단 경로를 알아내는 알고리즘입니다.
