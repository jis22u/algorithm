package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림 {

	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		
		int cnt = 0;
		int area = 0;
		int max = 0;
		Queue<Node> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					cnt++;
					map[i][j] = 0;
					area = 1;
					q.add(new Node(i,j));
					
					while(!q.isEmpty()) {
						Node node = q.poll();
						
						for(int d=0; d<4; d++) {
							int nr = node.r + dr[d];
							int nc = node.c + dc[d];
							
							if(nr>=n || nc>=m || nr<0 || nc<0) continue;
							if(map[nr][nc] == 0) continue;
							
							area++;
							map[nr][nc] = 0;
							q.add(new Node(nr,nc));
						}
					}
				}
				max = Math.max(max, area);
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	} //main

}
