package 완전탐색;

import java.util.Scanner;

// 프로그래머스
public class 피로도 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[][] dungeons = new int[3][2];
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				dungeons[i][j] = sc.nextInt();
			}
		}
		
		max = Integer.MIN_VALUE;
	    d = dungeons;
	    visited = new boolean[d.length]; 
	    order(k,0,0);
	        
	     int answer = max;
	     System.out.println(answer);
	     
	} // main

	static int max, d[][];
	static boolean[] visited;
	static void order(int k, int idx, int cnt) {
	    if(idx == d.length) {
	        max = Math.max(cnt, max);
	        return;
	    }
	    
	    for(int i=0; i<d.length; i++) {
	        if(visited[i]) continue;
	        
	        if(k >= d[i][0]) {
	            visited[i] = true;
	            order(k-d[i][1], idx+1, cnt+1);
	        } else {
	            visited[i] = true;
	            order(k, idx+1, cnt);
	        }
	        
	        visited[i] = false;
	    }
	    
	}
}
