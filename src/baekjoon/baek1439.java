package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek1439 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
//		char[] arr = {'0','1'};
		int cnt0 = 0;
		int cnt1 = 0;
//		int i=0;
//		int j=0;
//		while(i<str.length()) {
//		for(int j=0; j<2; j++) {
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '0') {
					i++;
				} else {
					cnt1++;
				}
			}
//		}
		
		
		
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(3));
		
	} // main

}
