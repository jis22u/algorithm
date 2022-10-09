package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


// swea5948. 새샘이
// TreeSet활용2 이어서 재귀+반복문으로 돌린 조합

public class swea새샘이_조합_재귀2 {
	static int[] arr, selected;
	static boolean[] visited;
	static TreeSet<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			arr = new int[7];
			selected = new int[3];
			visited = new boolean[7];
			set = new TreeSet<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(0,0);
			for(int i=1; i<5; i++) {
				set.remove(set.last());
			}
			System.out.println("#"+t+" "+set.last());
		}
	} // main
	
	// 그냥 dfs구나
	static void combi(int N, int sum) {
		if(N == 3) {
			set.add(sum);
			return;
		}

		for(int i=0; i<7; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			selected[N] = arr[i];
			combi(N+1, sum+arr[i]);
			visited[i] = false;
		}
	} //combi
}
