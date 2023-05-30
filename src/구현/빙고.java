import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고 {
	public static void main(String[] args) throws IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] binggo = new int[5][5];      // 빙고판 숫자
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				binggo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] check = new int[5][5];       // 부른 숫자 체크
		int ti = 0;                          // 해당 인덱스 r
		int tj = 0; 					     // 해당 인덱스 c
		int cnt = 0;
		int sum = 0;
		int target = 0;
		boolean Lflag = false;
		boolean Rflag = false;

		outter:
		for(int r=0; r<5; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<5; c++) {
				target = Integer.parseInt(st.nextToken());
				// 빙고판에서 해당 숫자의 인덱스 찾아
				for(int i=0; i<5; i++) {
					for(int j=0; j<5; j++) {
						// 체크판에 1체크
						if(binggo[i][j] == target) {
							ti = i;
							tj = j;
							check[ti][tj] = 1;
							break;
						}
					}
				}

				// 그 인덱스를 기준으로 가로, 세로, 대각선 합이 5이면 체크
				sum = 0;
				int mi = ti;
				int mj = tj;
				// 1) 세로 합 찾아보자
				while(mi<5) {
					sum += check[mi++][mj];
				}
				mi = ti;
				while(mi>=0) {
					sum += check[mi--][mj];
				}
				if(sum-check[ti][tj] == 5) { cnt++; }

				sum = 0;
				mi = ti;

				// 2) 가로 합 찾아보자
				while(mj<5) {
					sum += check[mi][mj++];
				}
				mj = tj;
				while(mj>=0) {
					sum += check[mi][mj--];
				}
				if(sum-check[ti][tj] == 5) { cnt++; }

				sum = 0;

				// 3) 대각선(왼쪽-오른쪽) 합 찾아보자
				int[] dr = {0, 1, 2, 3, 4};
				int[] dc = {0, 1, 2, 3, 4};
				for(int d=0; d<5; d++) {
					sum += check[dr[d]][dc[d]];
				}
				if(!Lflag && sum == 5) { cnt++; Lflag = true;}


				sum = 0;

				// 4) 대각선(오른쪽-왼쪽) 합 찾아보자
				dr = new int[]{0, 1, 2, 3, 4};
				dc = new int[]{4, 3, 2, 1, 0};
				for(int d=0; d<5; d++) {
					sum += check[dr[d]][dc[d]];
				}
				if(!Rflag && sum == 5) { cnt++;  Rflag = true;}

				if(cnt >= 3) {
					System.out.println((r*5)+c+1);
					break outter;
				}
			}
		}
	}
}
