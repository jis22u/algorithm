package 완전탐색;

import java.io.*;
import java.util.*;

public class 별똥별 {

	
	/**
	 * 메모리초과
	 * K를 이용해서 완전탐색해야 함
	 * 시간복잡도는 O(N^3)으로 K의 최대값이 100이기 때문에 
	 * 시간 내에 풀 수 있다
	 * 시간제한은 2초
	 */
	static int N,M,L,K,stars[][],min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N: 구역 가로길이 M: 구역 세로길이 L: 트램펄린 한변의 길이 K: 별똥별 개수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 별똥별이 떨어지는 좌표값들 저장
		stars = new int[K][2];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				stars[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 최소값 찾자
		min = Integer.MAX_VALUE;
		
		// 두 개의 별 선택해서
		// 각각 x,y좌표 뽑아내자
		for(int i=0; i<K; i++) {
			for(int j=0; j<K; j++) {
				// 각각 x좌표, y좌표
				search(stars[i][0], stars[j][1]);
			}
		}
		
		System.out.println(min);
	} // main

	static void search(int x, int y) {
		
		int cnt = 0;
		for(int i=0; i<K; i++) {
				if(x<=stars[i][0] && stars[i][0]<=x+L && y<=stars[i][1] && stars[i][1]<=y+L) cnt++;
		}
		
		min = Math.min(K-cnt, min);
	}
}
