package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class strReplace {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int ans = 0;
			
			int n = Integer.parseInt(br.readLine());
			String key = br.readLine();
			String str = br.readLine();
			
			String tmp = str.replace(key, "ㅋ");
			for(int i=0; i<tmp.length(); i++) {
				if(tmp.charAt(i)=='ㅋ') {
					ans++;
				}
			}
			
			System.out.println("#"+n+" "+ans);
		}
		
		
	} //main

}
