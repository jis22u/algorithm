package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수리공항승 {

	public static void main(String[] args) throws IOException {
		/**
		 * 물이 새는 곳을 정렬하여 저장하고
		 * 붙인 시작점에서 테이프 길이만큼의 범위 안에 들어오는지
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 물이 새는 곳의 개수: N, 테이프의 길이: L
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 1. N개 입력받기
		int[] leak = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			leak[i] = Integer.parseInt(st.nextToken());
		}
		
		// 물이 새는 곳 leak배열 정렬
		Arrays.sort(leak);
		
		// 2. 테이프 붙이기
		// 테이프를 붙인 시작점 위치, 맨 앞부터 붙일 것이므로
		double stTape = leak[0]-0.5;
		// 테이프 개수, 일단 붙여놓고 시작하기 때문에 1
		int cnt = 1;
		for(int i=0; i<N; i++) {
			// 시작점에서 테이프 길이만큼의 범위를 넘어가면
			if(stTape + L < leak[i]) {
				// 테이프 더 필요
				cnt++;
				stTape = leak[i] - 0.5;
			}
		}
		
		System.out.println(cnt);
	}

}
