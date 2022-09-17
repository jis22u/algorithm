package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea3431 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			
			int ans = (x<l)? l-x : ((x>u)? -1 : 0);
			System.out.println("#"+t+" "+ans);
		}

		br.close();
		
	} //main

}
