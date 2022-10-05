package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


// 풀다말앗따
public class baek연결요소의개수 {

	static class Edge{
		int st, ed;
		
		Edge(int st, int ed){
			this.st = st;
			this.ed = ed;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		
		List<Integer>[] adjArr = new ArrayList[n+1];
		
		
		for(int i=0; i<m; i++) {
			stz = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stz.nextToken());
			int ed = Integer.parseInt(stz.nextToken());
			adjArr[st].add(ed);
		}
		
		boolean[] check = new boolean[n+1];
		int cnt=0;
		for(int i=1; i<n+1; i++) {
			if(check[i]) {
				for(int j=0; j<adjArr[i].size(); j++) {
					check[adjArr[i].get(j)] = true;
				}
			}
		}
		
	} //main

}
