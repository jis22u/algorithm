package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek섬의개수 {

	static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			int[][] map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 탐색하면서, 육지인 경우. 카운트를 하나 세고, 연결된 모든 육지를 삭제
			int cnt = 0;
			int[] dr = {-1,1,0,0,-1,-1,1,1};
			int[] dc = {0,0,1,-1,1,-1,1,-1};
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 ) {
						// 개수 하나 세고
						cnt++;
						
						// 연결된 모든 육지를 0으로 삭제
						// 시작위치를 큐에 삽입하여 방문체크!!
						map[i][j] = 0;
						Queue<Node> queue = new LinkedList<>();
						Node node = new Node(i, j);
						queue.add(node);
						while(!queue.isEmpty()) {
							
							Node n = queue.poll();
							for(int k=0; k<8; k++) {
								int nr = n.r + dr[k];
								int nc = n.c + dc[k];
								
								if(nr<0 || nc<0 || nr>=h || nc>=w) continue;
								if(map[nr][nc] == 0) { 
									continue;
								} else {
									map[nr][nc] = 0;
									node = new Node(nr, nc);
									queue.add(node);
								}
							}
						}
					} else {
						continue;
					}
				}
			}
			
			System.out.println(cnt);
		} // while
		
		
	} //main

}
