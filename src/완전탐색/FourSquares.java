package 완전탐색;

import java.util.Scanner;


// 시간초과
public class FourSquares {

	static int[] arr;
	static int n, m, ans;
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		
		// 정수 m까지 완전탐색을 할거야
		m = (int) Math.sqrt(n);
		
		
		// 1부터 m까지의 수가 저장된 배열
		arr = new int[m];
		for(int i = 0; i<m; i++) {
			arr[i] = (int) Math.pow(i+1, 2);
		}
		
		ans = Integer.MAX_VALUE;
		
		// 방문처리
		visited = new boolean[m];
		
		search(0, 0);
		
		System.out.println(ans);
		
		
	} // main
	
	static void search(int res, int sCnt) {
		if(sCnt >= ans) return;
		if(res == n) {
			ans = Math.min(sCnt, ans);
			return;
		} else if(sCnt == 4) return;
	
		for(int i = 0; i<m; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			search(res+ arr[i], sCnt+1);
			visited[i] = false;
		}
	}

}
