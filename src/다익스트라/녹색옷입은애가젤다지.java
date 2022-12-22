package 다익스트라;

// 다잌 배운대로 다시 풀어볼까
// visited 처리를 이상하게 하긴 함. 
// 방문한 곳을 체크한게 아니라 방문할 곳을 체크함 ㅠ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {
	
	static class Node implements Comparable<Node>{
		// cost는 이전까지 지나온 최소비용이 담길 것
		int r,c,cost;
		
		Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
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
			
			// 정점마다 최소비용 저장, 일단 무한대로 초기화할 것
			int[][] dist = new int[N][N];
			
			if(N == 0) break;
			
			// N*N 도둑루피들
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			// 방문 체크
			boolean[][] visited = new boolean[N][N];
			// 도둑 루피들 담을 pq
			PriorityQueue<Node> pq = new PriorityQueue<>();
			// 하우상좌 순으로 탐색
			// 일단 최소한으로 이동하는 것이 소지금을 최대한 지키는 것이므로
			int[] dr = {1,0,-1,0};
			int[] dc = {0,1,0,-1};
			
			// 0,0 부터 출발
			pq.add(new Node(0,0,cave[0][0]));
			dist[0][0] = cave[0][0];
			
			// 정답
			int ans = 0;
			
			// 나머지 탐색 ㄱ
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				
				// 목표지점까지 도달, 더 탐색할 필요 없음 털리기만 함
				// 마지막 (N-1, N-1) 정점의 가중치까지 더해주기
				if(n.r == N-1 && n.c == N-1) {
					ans = n.cost + cave[n.r][n.c];
					break;
				}
				
				if(visited[n.r][n.c]) continue;
				
				// 방문한 곳 체크
				visited[n.r][n.c] = true;
				
				// 앞으로 지나갈 곳 탐색
				for(int d=0; d<4; d++) {
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					
					if(nr<0||nc<0||nr>=N||nc>=N) continue; 

					if(!visited[nr][nc] && dist[nr][nc] > dist[n.r][n.c] + cave[nr][nc]) {
						dist[nr][nc] = dist[n.r][n.c] + cave[nr][nc];
						pq.add(new Node(nr,nc,dist[n.r][n.c]));
					}
				}
				
			}
			
			System.out.println("Problem "+ t++ +": "+ans);
		}
	} // main

}

// bfs는 시작점에서부터 동일한 거리를 짧은 순서대로 탐색합니다.
// 거리가 1인 곳, 거리가 2인 곳, 거리가 3인 곳 이렇게 촘촘히 검사하지요. 
// 따라서 거리가 3인 곳을 방문할 땐 거리가 2인 곳에서 다시 거리가 1인 곳으로 가지 않습니다.
// 왔던 곳을 다시 가지 않는다는 말입니다.
// 그러나 다익스트라는 왔던 곳을 다시 가기도 합니다. 
// 왔던 곳을 방문하는 더 빠른 최단경로가 존재한다면 말이지요.
// 따라서 알고리즘의 목적 자체가 다른 겁니다. 
// bfs는 모든 곳을 둘러보는 알고리즘이며 다익스트라는 모든 곳에 대해서 방문하는 최단 경로를 알아내는 알고리즘입니다.
