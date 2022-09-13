package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1215 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int len = Integer.parseInt(br.readLine()); 
			char[][] arr = new char[8][8];
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				for(int j=0; j<8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			
			// 행 순회
			int cnt = 0;
			int jj = 0;
			String ori="";
			String rev="";
			StringBuilder sb;
			for(int i = 0; i<8; i++) {
				for(int j = 0; j<=8-len; j++) {
					jj = j;
					sb = new StringBuilder(ori);
					while(jj<8 && sb.length() != len) {
						sb.append(arr[i][jj]);
						jj++;
					}
					
					ori = sb.toString();
					rev = sb.reverse().toString();
					if(ori.equals(rev)) {
						cnt++;
					}
					
					ori="";
					sb.setLength(0);
				}
			}
				
			// 열 순회
			ori="";
			rev="";
			for(int i = 0; i<8; i++) {
				for(int j = 0; j<=8-len; j++) {
					jj = j;
					sb = new StringBuilder(ori);
					while(jj<8 && sb.length() != len) {
						sb.append(arr[jj][i]);
						jj++;
					}
					
					ori = sb.toString();
					rev = sb.reverse().toString();
					if(ori.equals(rev)) {
						cnt++;
					}
					
					ori="";
					sb.setLength(0);
				}
			}
			
			System.out.println("#"+t+" "+cnt);
				
		}
		br.close();
			
	} //main

}
