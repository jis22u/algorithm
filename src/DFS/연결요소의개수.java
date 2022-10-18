package DFS;

import java.util.Scanner;

// 백준11724
public class 연결요소의개수 {

	static int N, cnt;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();

		check = new boolean[N + 1];
		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			map[st][ed] = 1;
			map[ed][st] = 1;
		}

		cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!check[i]) {
				cnt++;
				dfs(i);
			}
		}

		System.out.println(cnt);

	} // main

	static void dfs(int i) {
		if(check[i]) return;
			
		check[i] = true;

		for (int c = 1; c < N + 1; c++) {
			if(map[i][c] == 1) {
				dfs(c);
			}
		}
	}
}
