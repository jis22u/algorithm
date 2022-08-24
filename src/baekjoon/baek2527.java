package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 직사각형
public class baek2527 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			

			if(p<x2 || p2<x || q<y2 || q2<y) {
				System.out.println("d");
			} else if(x2==p && q==y2 || x==p2 && y==q2 || q==y2 && x==p2 || x2 ==p && y == q2) {
				System.out.println("c");
			} else if(x2==p || x==p2 || q==y2 ||y ==q2) {
				System.out.println("b");   
			} else {
				System.out.println("a");
			}
			
		} //for

	} // main

}
