package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 원재의 메모리 복구하기
public class swea1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			// after 배열 원래값
			String str = br.readLine();
			int len = str.length();
			char[] after = str.toCharArray();
			
			// before 배열 초기값
			char[] before = new char[len];
			for(int i=0; i<len; i++) {
				before[i] = '0';
			}
			
			// 값 비교
			int cnt=0;
			for(int i=0; i<len; i++) {
				if(after[i] != before[i]) {
					int idx = i;
					char value = after[i];
					while(idx <= len-1) {
						before[idx++] = value;
					}
					cnt++;
				} 
			}
			System.out.println("#"+t+" "+cnt);
			
		} //for
		
	} //main

}