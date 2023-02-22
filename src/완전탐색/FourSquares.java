package 완전탐색;

import java.util.Scanner;

public class FourSquares {

	static int[] arr;
	static int cnt, n, m, ans;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		// 정수 m까지 완전탐색을 할거야
		m = (int) Math.sqrt(n);
		System.out.println(m);
		
		
		// 1부터 m까지의 수가 저장된 배열
		arr = new int[m];
		for(int i = 0; i<m; i++) {
			arr[i] = i+1;
		}
		
		ans = Integer.MAX_VALUE;
		
		// 방문처리
		visited = new boolean[m];
		
		// 1개부터 m개까지 숫자를 선택할거야
//		for(int i = 0; i<m; i++) {
//			// 선택할 정수의 개수
//			cnt = i+1;
			// 제곱수의 합, 선택된 정수의 개수
			search(0, 0);
//		}
		
		System.out.println(ans);
		
		
	} // main
	
	static void search(int res, int sCnt) {
		if(res == n) {
			ans = Math.min(sCnt, ans);
			return;
		} else if(sCnt == m) return;
		
	
		for(int i = 0; i<m; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			search(res+(int) Math.pow(arr[i], 2), sCnt+1);
			visited[i] = false;
		}
	}

}
