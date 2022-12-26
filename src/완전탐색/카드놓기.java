package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 카드놓기 {

	static int n,k;
	static String[] num;
	static boolean[] visited;
	static HashSet<String> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		num = new String[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			num[i] = br.readLine();
		}
		
		set = new HashSet<>();
		select(0,"");
		
		int ans = set.size();
		System.out.println(ans);
		
	}
	
	static void select(int cnt, String cur) {
		if(cnt == k) {
			set.add(cur);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			select(cnt+1, cur+num[i]);
			visited[i] = false;
		}
	}

}
