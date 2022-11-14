package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		long[] roads = new long[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			roads[i] = Long.parseLong(st.nextToken());
		}
		
		
		long[] city = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			city[i] = Long.parseLong(st.nextToken());
		}
		
		long[] sorted = new long[N];
		sorted[0] = city[0];
		long min = city[0];
		for(int i=1; i<N; i++) {
			if(min > city[i]) {
				min = city[i];
				sorted[i] = min;
			} else {
				sorted[i] = min;
			}
		}
		
		long cost = 0;
		for(int i=0; i<N-1; i++) {
			cost += (sorted[i] * roads[i]);
		}
		System.out.println(cost);
		
	} //main

}
