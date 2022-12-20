package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티 {

	static class Node implements Comparable<Node>{
		int ed, time;
		Node(int ed, int time) {
			this.ed = ed;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}
	
	static int N,M;
	static List<Node>[] goParty, goHome;
	static int[] distForParty, distForHome;
	public static void main(String[] args) throws IOException {
		// 인접리스트
		// 다익스트라
		// 파티장으로 가는 길, goParty
		// 집으로 돌아오는 길, goHome
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N: 정점의 개수, M: 간선의 개수, X: 파티장
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		int X = Integer.parseInt(stz.nextToken());
		
		// 인접리스트로 저장할거다, 근데 정점이 1번부터 시작한다
		goParty = new ArrayList[N+1];
		goHome = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			goParty[i] = new ArrayList<>();
			goHome[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			stz = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stz.nextToken());
			int ed = Integer.parseInt(stz.nextToken());
			int time = Integer.parseInt(stz.nextToken());
			
			goParty[st].add(new Node(ed, time));
			goHome[ed].add(new Node(st, time));
		}
		
		// 최단거리 저장하는 용도
		distForParty = new int[N+1];
		distForHome = new int[N+1];
		
		// 일단 무한대로 초기화
		Arrays.fill(distForParty, Integer.MAX_VALUE);
		Arrays.fill(distForHome, Integer.MAX_VALUE);
		
		// 파티장 가는 길~~
		dijkstra(X, 100);
		// 집으로 돌아오는 길~
		dijkstra(X, 0);
		
		int max = 0;
		for(int i=1 ; i<=N; i++) {
			int sum = distForParty[i]+distForHome[i];
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
			
	} // Main
	
	static void dijkstra(int start, int energy) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		boolean[] visited = new boolean[N+1];
		
		pq.add(new Node(start, 0));
		
		// 시작 노드 - 시작 노드 이므로 시간은 0
		distForParty[start] = 0;
		distForHome[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			// 이미 최단시간 처리한 것은 더 안봐도 돼
			if(visited[curr.ed]) continue;
			
			visited[curr.ed] = true;
			
			if(energy == 100) {
				for(Node node : goParty[curr.ed]) {
					if(!visited[node.ed] && distForParty[node.ed] > distForParty[curr.ed] + node.time) {
						distForParty[node.ed] = distForParty[curr.ed] + node.time;
						pq.add(new Node(node.ed, distForParty[node.ed]));
					}
				}
			} else {
				for(Node node : goHome[curr.ed]) {
					if(!visited[node.ed] && distForHome[node.ed] > distForHome[curr.ed] + node.time) {
						distForHome[node.ed] = distForHome[curr.ed] + node.time;
						pq.add(new Node(node.ed, distForHome[node.ed]));
					}
				}
			}
			
		}
	}

}
