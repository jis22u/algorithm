package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 치킨치킨치킨 {
// 백준 16439
	
	
	static int N,M, ans;
	static int[][] info;
	static int[] sel,chicken;
	public static void main(String[] args) throws IOException {
		/**
		 * 치킨은 무조건 3가지 선택하니까
		 * 먼저 3가지 선택하고서 최대값 구할거야
		 * 그 중 제일 최대값이 답
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N: 회원수 M: 치킨종류 수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 각 회원의 치킨 선호도 값
		info = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 선택한 치킨 저장 0번치킨 ~ M-1번치킨
		sel = new int[3];
		// 정답~
		ans = 0;
		// 세가지 골라서 최대값 다 찾아보자
		combi(0,0);
		
		System.out.println(ans);
	}
	
	// idx는 sel 몇번째 원소, sidx는 M가지 치킨 중 선택한 치킨번호
	static void combi(int idx, int sidx) {
		if(idx == 3) {
			// 선택한 3가지에 대해 각 회원들의 최대값 찾기
			int sum = 0;
			for(int i=0; i<N; i++) {
				int max = 0;
				for(int j=0; j<3; j++) {
					max = Math.max(max, info[i][sel[j]]);
				}
				sum += max;
			}
			ans = Math.max(sum, ans);
			return;
		}
		if(sidx == M) return;
		
		sel[idx] = sidx;
		combi(idx+1, sidx+1);
		combi(idx, sidx+1);
	}

}
