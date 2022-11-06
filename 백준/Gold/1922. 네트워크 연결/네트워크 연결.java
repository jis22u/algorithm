import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 컴터 = 정점
		int M = Integer.parseInt(br.readLine()); // 연결선 = 간선
		
		// 간선 정보좀 저장하자
		int[][] edges = new int[M][3];
		StringTokenizer stz;
		for(int i=0; i<M; i++) {
			stz = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(stz.nextToken()); 
			edges[i][1] = Integer.parseInt(stz.nextToken());
			edges[i][2] = Integer.parseInt(stz.nextToken());
		}
		
		// 정렬 필요
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// 일단 대표자 지정
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		// MST ㄱㄱ
		int ans = 0;
		int pick = 0;
		for(int i=0; i<M; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);
			
			if(px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}
			
			if(pick == N-1) break;
		}
		
		System.out.println(ans);
		
	} // main

	// 대표자 좀 찾을게
	static int findSet(int x) {
		if(x != p[x]) 
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	
	// 병합
	static void union(int x, int y) {
		p[y] = x;
	}

}