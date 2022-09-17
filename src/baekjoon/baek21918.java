package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek21918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] lights = new int[n+1];
		st= new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<c; i++) {
			st = new StringTokenizer(br.readLine());

			int sel = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(sel == 1) {
				lights[a] =b;
			} else if(sel == 2) {
				for(int j=a; j<=b; j++) {
					if(lights[j] == 0) {
						lights[j]=1;
					} else {
						lights[j]=0;
					}
				}
			} else if(sel == 3) {
				for(int j=a; j<=b; j++) {
					lights[j]=0;
				}
			} else if(sel == 4) {
				for(int j=a; j<=b; j++) {
					lights[j]=1;
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			sb.append(lights[i]+" ");
		}
		
		System.out.println(sb.delete(sb.length()-1, sb.length()));
		br.close();
		
	} // main

}
