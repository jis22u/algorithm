package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] roads = new int[N-1];
		String str = br.readLine().replace(" ","");
		for(int i=0; i<N-1; i++) {
			roads[i] = str.charAt(i)-'0';
		}
		int[] price = new int[N];
		str = br.readLine().replace(" ","");
		for(int i=0; i<N; i++) {
			price[i] = str.charAt(i)-'0';
		}
		
		int len = 0;
		int ans = 0; 
		int result = 0;
		int past = 1000000001;
		for(int i=N-2; i>=0; i--) {
			int now = price[i];
			
			if(now <= past) {
				len += roads[i];
				ans = now * len;
			} else {
				len = roads[i];
				ans = now * len;
			}
			past = now;
			
		}
		System.out.println(ans);
		
	} //main

}
