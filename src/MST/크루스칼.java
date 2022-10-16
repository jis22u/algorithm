package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


// swea3124
public class 크루스칼 {

	static int[] boss;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// 간선 정보 저장
			// [][0]: 시작정점, [][1]: 도착정점, [][2]: 가중치
			int[][] edges = new int[E][3];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<3; j++) {
					edges[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 정렬
			Arrays.sort(edges, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			// Make-Set. 나 자신을 대표자로 지정
			boss = new int[V+1];
			for(int i =1; i<V+1; i++) {
				boss[i] = i;
			}
			
			// MST를 만들어보자
			long ans = 0;
			int pick = 0;
			for(int i=0; i<E; i++) {
				// i번째 간선을 뽑아서 두 정점의 대표를 확인다.
				int px = findSet(edges[i][0]); 
				int py = findSet(edges[i][1]);
				
				// 각각의 대표가 다르면								
				if(px != py) {
                	// 합병
					union(px, py);
                    // 최소 가중치 중 하나로 선택 즉, 연결
					ans += edges[i][2];			
					pick++;
				}

				if(pick == V-1) break;
			}
			
			System.out.println("#"+t+" "+ans);
			
		} // tc
	} //main
	
	
	// Find-set. 대표자 찾기
	static int findSet(int x) {
		if (x != boss[x])
			boss[x] = findSet(boss[x]);
		return boss[x];
	}
	
	
	// Union. 병합
	static void union(int x, int y) {
		boss[y] = x;
	}
}
