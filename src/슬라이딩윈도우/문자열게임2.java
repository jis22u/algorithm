package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// XX
public class 문자열게임2 {

	static String W;
	static int K,len, alpha[], ans3, ans4;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			W = br.readLine();
			K = Integer.parseInt(br.readLine());
			len = W.length();
			
			// 영어 소문자 개수 카운트, 0번 인덱스가 a
//			alpha = new int[26];
			
			// 3번
			ans3 = 0;
			three();
			
			// 4번
			ans4 = 0;
			four();
			
			StringBuilder sb = new StringBuilder();
			sb.append(ans3+" ").append(ans4);
			if(ans3 == 0 || ans4 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(sb.toString());
			}
		}
		 
	} // main
	
	static void three() {
		// 최소한 K개부터는 검사해야함
		for(int i=K; i<len; i++) {
			int st = 0;
			int ed = st + i - 1;
			alpha = new int[26];
			
			for(int j=st; j<=ed; j++) {
				alpha[W.charAt(j)-'a']++;
			}
			
			for(int p=0; p<26; p++) {
				if(alpha[p] == K) {
					ans3 = ed - st + 1;
					return;
				}
			}

			while(st<len || ed<len) {
				alpha[W.charAt(st)-'a']--;
				st++;
				ed++;
				alpha[W.charAt(ed)-'a']++;
				
				for(int p=0; p<26; p++) {
					if(alpha[p] == K) {
						ans3 = ed - st + 1;
						return;
					}
				}
			}
		}
	}
	
	static void four() {
		// 최소한 K개까지는 검사해야함
		for(int i=len; i>=K; i--) {
			int st = 0;
			int ed = st + i - 1;
			alpha = new int[26];
			
			for(int j=st; j<=ed; j++) {
				alpha[W.charAt(j)-'a']++;
			}
			
			for(int p=0; p<26; p++) {
				if(alpha[p] == K) {
					if((W.charAt(ed) - 'a') == p && (W.charAt(st-1) -'a') == p) {
						ans4 = ed - st + 1;
						return;
					}
				}
			}

			while(st<len || ed<len) {
				alpha[W.charAt(st)-'a']--;
				st++;
				ed++;
				alpha[W.charAt(ed)-'a']++;
				
				for(int p=0; p<26; p++) {
					if(alpha[p] == K) {
						if((W.charAt(ed) - 'a') == p && (W.charAt(st-1) -'a') == p) {
							ans4 = ed - st + 1;
							return;
						}
					}
				}
			}
			
		}
	}

}
