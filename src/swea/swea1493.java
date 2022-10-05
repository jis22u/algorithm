package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1493 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			StringTokenizer str1 = new StringTokenizer(amper(a));
			int x1 = Integer.parseInt(str1.nextToken());
			int y1 = Integer.parseInt(str1.nextToken());
			
			StringTokenizer str2 = new StringTokenizer(amper(b));
			int x2 = Integer.parseInt(str2.nextToken());
			int y2 = Integer.parseInt(str2.nextToken());
			
			ans = hash(x1+x2, y1+y2);
			System.out.println("#"+t+" "+ans);
		}
		
	} //main

	
	// #(x,y) 연산자
	static int hash (int x, int y) {
		return x+(((x+y-1)*(x+y-2))/2);
	} // hash
	
	// $() 연산자
	static String amper(int num) {
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=1000; j++) {
				if(hash(i,j) == num) {
					return i+" "+j;
				}
			}
		}
		return null;
	} // amper
	
}
