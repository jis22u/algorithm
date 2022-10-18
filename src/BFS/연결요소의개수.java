package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 백준11724
public class 연결요소의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		boolean[] check = new boolean[N+1];
		boolean[][] map = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stz.nextToken());
			int ed = Integer.parseInt(stz.nextToken());
			map[st][ed] = true;
			map[ed][st] = true;
		}
		
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(!check[i]) {
				cnt++;
				q.add(i);
				check[i] = true;
				
				while(!q.isEmpty()) {
					int now = q.poll();
					
					for(int c = 1; c<=N; c++) {
						if(map[now][c] && !check[c]) {
							check[c] = true;
							q.add(c);
						}
					}
				}
			}
		}
		System.out.println(cnt);

		
	}

}
