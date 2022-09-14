package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea7087 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[26];
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				check[str.charAt(0)-65] = true;
			}
			
			int cnt = 0;
			for(int i=0; i<26; i++) {
				if(check[i]) {
					cnt++;
				} else {
					break;
				}
			}
			System.out.println("#"+t+" "+cnt);
			
		}
		br.close();
		
	} //main

}
