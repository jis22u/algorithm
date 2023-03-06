package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모음이보이지않는사람 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String str = br.readLine();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
					str = str.replace(str.charAt(i) +"", "1");
				}
			}
			
			String res = str.replaceAll("1", "");
			System.out.println("#"+t+" "+res);
		}

	}

}
