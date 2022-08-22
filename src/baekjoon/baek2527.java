package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 메모리초과.............
// 직사각형
public class baek2527 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr;

		for (int i = 0; i < 4; i++) {
			
			int[] nums = new int[8];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<8; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			int p = Integer.parseInt(st.nextToken());
//			int q = Integer.parseInt(st.nextToken());
//			int x2 = Integer.parseInt(st.nextToken());
//			int y2 = Integer.parseInt(st.nextToken());
//			int p2 = Integer.parseInt(st.nextToken());
//			int q2 = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for(int j=0; j<8; j++) {
				if(max < nums[j]) {
					max = nums[j];
				}
			}
			
			int len = max+1;
			arr = new int[len][len];
			
			for (int r = nums[1]; r <= nums[3]; r++) {
				for (int c = nums[0]; c <= nums[2]; c++) {
					++arr[r][c];
				}
			}
			
			for (int r = nums[5]; r <= nums[7]; r++) {
				for (int c = nums[4]; c <= nums[6]; c++) {
					++arr[r][c];
				}
			}

			int nr = 0;
			int nc = 0;
			int cnt = 0;
			for (int r = 0; r < len; r++) {
				for (int c = 0; c < len; c++) {
					if (arr[r][c] == 2) {
						cnt++;
						nr = r;
						nc = c;
					}

				}
			}

			if (cnt == 0) {
				System.out.println("d");
			} else if (cnt == 1) {
				System.out.println("c");
			} else {
				if (nc-1>0 && arr[nr][nc-1] == 2) {
					System.out.println("a");
				} else {
					System.out.println("b");
				}
			}

		}

	} // main

}
