package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2961 {

	static int n, cnt;
	static int[][] ingredi;
	static boolean[] select;
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 재료를 선택 - 부분집합, 공집합 제외
		// 재료 선택하고 나면, 신맛끼리 곱 - 쓴맛끼리 합
		// 최소값 보다 작으면 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		select = new boolean[n];
		StringTokenizer st;
		ingredi = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				ingredi[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cooking(0);
		System.out.println(min);
		
	}
	
	static int min = Integer.MAX_VALUE;
	static void cooking(int idx) {
		if(idx == n) {
			cnt++;
			if(cnt == 1) {
				return;
			}
			
			for(int i=0; i<n; i++) {
				if(!select[i]) {
				}
			}
			
			
			int sour = 1;
			int bitter = 0;
			for(int i=0; i<n; i++) {
				if(select[i]) {
					sour *= ingredi[i][0];
					bitter += ingredi[i][1];
				}
			}

			if(min > Math.abs(sour-bitter)) {
				min = Math.abs(sour-bitter);
			}
			
			return;
		} else {
			
			select[idx] = false;
			cooking(idx+1);
			select[idx] = true;
			cooking(idx+1);
		}
	}

}
