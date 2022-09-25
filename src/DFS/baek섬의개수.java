package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek섬의개수 {

	static int w, h;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1) {
						// 일단 cnt++
						// dfs에서 모든 육지를 바다로 바꿀 것 
						cnt++;
						dfs(i,j);
					}
				}
			}
			
			System.out.println(cnt);
		} // while

	} // main

	
	
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,1,-1,1,-1,1,-1};
	static void dfs(int i, int j) {
		// 해당 육지를 바다로 만들기
		map[i][j] = 0;
		
		
		// 육지, 바다 찾아나가기
		for(int p=0; p<8; p++){
			int ii = i+dr[p];
			int jj = j+dc[p];
			if(ii<0 || ii>=h || jj<0 || jj>=w) {
				continue;
			}
			
			if(map[ii][jj] == 0) {
				// 바다이면
				continue;
			} else {
				// 육지라면
				dfs(ii, jj);
			}
		}
		
	} //dfs

}