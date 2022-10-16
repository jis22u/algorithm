package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 초기화
// dist 배열 무한대로 값 넣기
// 시작 정점 0으로 바꾸기
// 시작 정점은 임의의 한 정점

// 반복
// 아직 방문하지 않았고, dist가 가장 최소값인 것 고르기 			> 3번
//	 		해당 정점 방문 체크			
//			해당 정점과 연결이 되어있고, 방문하지 않은 정점?		> 4번
//				if(4번의 이전 dist = 무한대 > 3번과 연결되어 생긴 dist = 34)
//				그 정점 갱신 = 3번과 연결되어 생긴 dist로 갱신
//				어느 정점에서 왔는지 체크 (p배열) : p배열=3
//				(4번 정점 방문체크 하는 게 아님)

public class 프림_반복문 {
	public static void main(String[] args) throws NumberFormatException, IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str;
		str = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(str.nextToken());
		int E = Integer.parseInt(str.nextToken());

		// 간선 정보 저장 : 인접행렬
		int[][] adjArr = new int[V + 1][V + 1];
		for (int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			int w = Integer.parseInt(str.nextToken());

			adjArr[st][ed] = w;
			adjArr[ed][st] = w;
		}

		// 필요한 배열들
		boolean[] visited = new boolean[V + 1];
		long[] weight = new long[V + 1]; 			// 갱신된 가중치들
//		int[] parents = new int[V+1];				// 어느 정점에서 왔는지 체크, 경로를 중시한다면 필요

		// 초기화 작업
		Arrays.fill(weight, Long.MAX_VALUE);
		weight[V] = 0;

		// 프림 알고리즘 시작
		for (int i = 1; i < V; i++) { 				// 정점이 V개라면 V-1번만 돌아도 된다.
			long min = Long.MAX_VALUE;
			int idx = -1;

			
			for (int j = 1; j < V + 1; j++) {
				if (!visited[j] && weight[j] < min) {	// 아직 방문하지 않았고, w값이 가장 최소인 것 고르기
					min = weight[j];
					idx = j; 							
				}
			} // 이 for문이 끝나면 idx에는 이번에 선택한 정점이 들어있다.
			
			visited[idx] = true;						// 해당 정점 방문 체크

			// 이제 여기서 weight 배열 갱신
			// 해당 정점과 연결되어있고, 아직 방문하지 않은 정점 중에서
			// 해당 정점과 연결되어 생긴 w값이 더 작다면 갱신
			for (int j = 1; j < V + 1; j++) {
				if (adjArr[idx][j] != 0 && !visited[j] && adjArr[idx][j] < weight[j]) {
					weight[j] = adjArr[idx][j];
//						p[j] = idx;
				}
			}
		}

		// MST 최소비용 뽑아내기
		long ans = 0;
		for (int i = 1; i < V + 1; i++) {
			ans += weight[i];
		}

		System.out.println(ans);

	} // main

}