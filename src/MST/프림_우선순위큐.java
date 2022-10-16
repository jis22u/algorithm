package MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


// 간선에 타협한 프림(정점 중심)
// 정석 프림은 아니다
public class 프림_우선순위큐 {
	static class Edge implements Comparable<Edge> {
		int st, ed, cost;

		public Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		// 우선순위큐를 활용하기 위해서 기준을 정해준다.
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Edge [st=" + st + ", ed=" + ed + ", cost=" + cost + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			// 간선의 정보를 저장 : 인접리스트
			List<Edge>[] adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				int st = sc.nextInt() - 1; 				// 시작정점
				int ed = sc.nextInt() - 1; 				// 도착정점
				int w = sc.nextInt(); 					// 가중치

				adjList[st].add(new Edge(st, ed, w));
				adjList[ed].add(new Edge(ed, st, w));
			}

			boolean[] visited = new boolean[V];
			PriorityQueue<Edge> pq = new PriorityQueue<>();

			// 임의의 한 정점에서 시작한다.
			visited[0] = true;
			pq.addAll(adjList[0]);

			int pick = 1;
			long ans = 0;

			while (pick != V) {
				Edge edge = pq.poll();
				if (visited[edge.ed]) continue;			// 이미 뽑은 정점이었다면 continue

				ans += edge.cost;
				pq.addAll(adjList[edge.ed]);
				visited[edge.ed] = true;
				pick++;
			}
			System.out.println("#"+t+" "+ans);
		}
	}// main
}
