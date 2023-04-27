package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

	static int N, ans;
	static int[][] list;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// N일 동안 상담할 리스트
		list = new int[N][2];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		dfs(0, 0);
		System.out.println(ans);
	}
	
	static void dfs(int idx, int max) {
		ans = Math.max(ans, max);
		if(idx >= N) return;
		
		if(idx+list[idx][0] <= N) {
			dfs(idx+list[idx][0], max+list[idx][1]);
			dfs(idx+1, max);
		} else {
			dfs(idx+1, max);
		}
	}
}

// 3
// 1 5
// 3 1
// 1 1
