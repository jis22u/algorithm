package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class baek단지번호붙이기 {
	static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 입력받기
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j)-48;
			}
		}
		
		// 방문처리할 큐
		Queue<Node> queue = new LinkedList<>();
		// 정답 저장 리스트
		List<Integer> ansList = new ArrayList<>();
		// 4방 탐색
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 집 발견하면 해당 집을 큐에 저장하고 연결된 모든 집 삭제
				if(map[i][j] == 1) {
					cnt++;
					map[i][j] = 0;
//					Node node = new Node(i, j);
					queue.add(new Node(i, j));
					while(!queue.isEmpty()){
						Node node = queue.poll();
						// 4방 탐색으로 연결된 모든 집 찾기
						for(int k=0; k<4; k++) {
							int nr = node.r + dr[k];
							int nc = node.c + dc[k];
							if(nc<0 || nr<0 || nr>=n || nc>= n) continue;
							if(map[nr][nc] == 0) {
								continue;
							} else {
								cnt++;
								map[nr][nc] = 0;
//								node = new Node(nr, nc);
								queue.add(new Node(nr, nc));
							}
						}
					}
					ansList.add(cnt);
					cnt=0;
				}
			}
		}
		
		
		Collections.sort(ansList);
		System.out.println(ansList.size());
		for(int i=0; i<ansList.size(); i++) {
			System.out.println(ansList.get(i));
		}
		
	} //main

}
