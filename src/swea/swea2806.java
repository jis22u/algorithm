package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2806 {

	static int[][] board;
	static int n;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			cnt = 0;

			put(0, 0, 0);

			System.out.println("#" + t + " " + cnt);
		}

	} // main

	// 전달할 변수 몇번째 퀸인지, 체스판의 인덱스

	// return 조건.
	// 퀸변수 == N일 때
	// 해당 인덱스[][]에 놓을 수 없다면

	static void put(int Q, int i, int j) {
		if (Q == n) {
			// 모든 퀸을 판에 놓았다.
			cnt++;
			return;
		}

		if (!deltaCheck(i, j)) {
			// 해당 칸의 같은 열, 같은 대각선 방향으로 퀸이 이미 놓여져있다.
			return;
		}

		board[i][j] = 1;
		for (int k = 0; k < n; k++) {
			put(Q + 1, i + 1, k);
			board[i][k] = 0;
		}
//		board[i][j] = 0;
	}

	static boolean deltaCheck(int i, int j) {
		int r = i;
		int c = j;
		// 열 검사
		while (r > 0) {
			if (board[--r][j] == 1)
				return false;
		}

		// 오른쪽 대각선 검사
		r = i;
		while (r > 0 && c < n - 1) {
			if (board[--r][++c] == 1)
				return false;
		}

		// 왼쪽 대각선 검사
		r = i;
		c = j;
		while (r > 0 && c > 0) {
			if (board[--r][--c] == 1)
				return false;
		}

		
		return true;
	}

}
