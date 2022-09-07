package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 안경이 없어!
public class swea7272 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {
		
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			int a = 0;
			for(int i=0; i<str1.length(); i++) {
				char c = str1.charAt(i);
				if(c == 'A' || c =='D' || c =='O' || c =='P'|| c =='Q'|| c =='R') {
					a = 10*a + 1;
				} else if (c == 'B'){
					a = 10*a + 2;
				} else {
					a = 10*a + 3;
				}
			}
			
			
			String str2 = st.nextToken();
			int b = 0;
			for(int i=0; i<str2.length(); i++) {
				char c = str2.charAt(i);
				if(c == 'A' || c =='D' || c =='O' || c =='P'|| c =='Q'|| c =='R') {
					b = 10*b + 1;
				} else if (c == 'B'){
					b = 10*b + 2;
				} else {
					b = 10*b + 3;
				}
			}
			
			if(a-b == 0) {
				System.out.println("#"+t+" "+"SAME");
			} else {
				System.out.println("#"+t+" "+"DIFF");
			}
		}
		
		
	} //main

}
