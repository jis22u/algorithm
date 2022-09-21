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
		
		for(int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			
			check(1,0,0);
			
			System.out.println("#"+t+" "+cnt);
		}
		
		
	} //main
	
	// 전달할 변수 몇번째 퀸인지, 체스판의 인덱스
	
	// return 조건.
	// 퀸변수 == N일 때
	// 해당 인덱스[][]에 놓을 수 없다면
	
	static void check(int Q, int i, int j) {
		if(Q == n+1) {
			// 모든 퀸을 판에 놓았다.
			cnt++;
			return;
		}
		
		if(board[i][j] == 1) {
			// 해당 칸에는 이미 퀸이 놓여있다.
			return;
		}
		
		if() {
			// 8방 탐색 결과 해당 칸에 놓을 수 없다.
			return;
		}
		
		board[i][j] = 1;
		check(Q+1, i+1 j+1);
		
	}
	
	static boolean deltaCheck() {
		int[] dr = {-1, -1,-1,0,0,1,1,1};
		int[] dc = {-1,0,1,-1,1,-1,0,1};
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<8; k++) {
					if() {
						return false;
					}
				}
			}
		}
		
		
		
		 
		return true;
	}
	

}
