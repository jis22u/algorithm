package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 재귀함수
// 백트래킹
public class swea1247 {

	
	static int n;
	static int minDis;
	static int[] home;
	static int[] company;
	static int[][] distance;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t =1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			company = new int[2];
			home = new int[2];
			distance = new int[n][2];
			visited = new boolean[n];
			
			st = new StringTokenizer(br.readLine());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++) {
				for(int j=0; j<2; j++) {
					distance[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minDis = Integer.MAX_VALUE;
			perm(0, company[0], company[1], 0);
			System.out.println("#"+t+" "+minDis);
		}
		
		
	}// main
	
	public static void perm(int idx, int x, int y, int dis) {
		// 백트래킹
		if(dis>minDis) {
			return;
		}
		
		if(idx == n) {
			// 마지막 고객
			dis += (Math.abs(home[0] - x) + Math.abs(home[1] - y));
			minDis = Math.min(minDis , dis);
			return;
		}
		
		// 순열, 재귀함수
		for(int i = 0; i<n; i++) {
			if(!visited[i]) {
				visited[i] =true;
				perm(idx+1, distance[i][0], distance[i][1], dis + Math.abs(distance[i][0] - x) + Math.abs(distance[i][1] - y));
				visited[i] = false;
			}
		}
		
	}
}
