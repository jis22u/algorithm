package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek18511 {

	static int N, K, max;
	static int[] input;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		input = new int[K];						// 집합 K
		for(int i=0; i<K; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		dfs(0);
		System.out.println(max);
	} //main
	
	static void dfs(int ans) {
		if(ans > N) return;
		if(ans > max) {
			max = ans;
		} 
		
		for(int i =K-1; i>=0; i--) {	// K-1번만큼 for문을 돌려야함.
			dfs(input[i]+10*ans);		// 이전에 있던값을 *10씩 해주며 일의자리에 arr[i]를 넣어주는 형식으로 해준다.
		}
		
 	}

}
