package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea4698_again {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<String> list = new ArrayList<>();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			String d = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int i=a; i<=b; i++) {
				for(int j=2; j<=i; j++) {
					if(i%j == 0) {
						cnt++;
					}
				}
				
				if(cnt == 1) {
//					System.out.println(cnt);
					list.add(i+"");
				}
				cnt=0;
			}
			
			int prime = 0;
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).contains(d)) {
					prime++;
				}
//				System.out.println(list.get(i));
			}
			
			System.out.println("#"+t+" "+prime);
			list.clear();
			
		}
		br.close();
		
		
	} //main

}
