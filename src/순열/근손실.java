package 순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근손실 {

	static int[] kits;
	static boolean[] visited;
	static int N,K, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		kits = new int[N];
		for(int i=0; i<N; i++) {
			kits[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N];
		exercise(500, 0);
		System.out.println(ans);
		
	}
	
	static void exercise(int weight, int idx) {
		if(idx == N) {
			ans++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			if(weight-K+kits[i] < 500) continue;
			
			visited[i] = true;
			exercise(weight-K+kits[i], idx+1);
			visited[i] = false;
		}
	}

}
