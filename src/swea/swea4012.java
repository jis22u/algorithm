package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea4012 {

	static int n;
	static boolean[] visited;
	static int[] ingredients;
	static int[][] table;
	static int min=1000000000;
	static int[] a;
	static int[] b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t =1; t<=T; t++) {
			min=1000000000;
			n = Integer.parseInt(br.readLine());
			ingredients = new int[n];
			visited = new boolean[n+1];			// 선택한 인덱스는 true
			a = new int[n/2];					// A 음식들
			b = new int[n/2];					// B 음식들
			table = new int[n+1][n+1];
			
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 재료 번호 넣기
			for(int i=0; i<n; i++) {
				ingredients[i] = i+1;
			}
			
			combination(0,0);
			System.out.println("#"+t+" "+min);
		}
		
		
	} // main
	
	
	
	static void combination(int idx, int vidx) {
		if(vidx == n/2) {
			// visited 배열에서 true인 것들 = A음식
			int k=0;
			for(int i=1; i<n+1; i++) {
				if(visited[i]) {
					a[k++] = i;
				}
			}
		
			// A음식들 맛 구하기
			int sumA = 0;
			for(int p =0; p<n/2; p++) {
				for(int q=0; q<n/2; q++) {
					if(a[p] != a[q]) {
						sumA += table[a[p]][a[q]];
					}
				}
			}

			// visited 배열에서 false인 것들 = B음식
			k=0;
			for(int i=1; i<n+1; i++) {
				if(!visited[i]) {
					b[k++] = i;
				}
			}
		
		
			// B음식들 맛 구하기
			int sumB = 0;
			for(int p =0; p<n/2; p++) {
				for(int q=0; q<n/2; q++) {
					if(b[p] != b[q]) {
						sumB += table[b[p]][b[q]];
					}
				}
			}
			
			// 이전 최솟값 보다 작으면 저장
			if(min > Math.abs(sumA-sumB)) {
				min = Math.abs(sumA-sumB);
			}
			
			return;
		} else if(idx == n) return; 
		
		// 재료 선택
		visited[ingredients[idx]] = true;
		combination(idx+1, vidx+1);
		visited[ingredients[idx]] = false;
		combination(idx+1, vidx);
	}
	

}
