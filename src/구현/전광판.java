package 구현;

import java.util.*;
import java.io.*;

public class 전광판 {

	public static void main(String[] args) throws Exception {
		// 0-9까지 전광판 현황 저장
		boolean[][] numNeon = {
		    {true, true, true, true, true, true, false},  // 0 
		    {false, false, true, true, false, false, false},    // 1
		    {false, true, true, false, true, true, true},       // 2
		    {false, true, true, true, true, false, true},       // 3
		    {true, false, true, true, false, false, true},      // 4
		    {true, true, false, true, true, false, true},       // 5
		    {true, true, false, true, true, true, true},        // 6
		    {true, true, true, true, false, false, false},      // 7
		    {true, true, true, true, true, true, true},         // 8
		    {true, true, true, true, true, false, true}         // 9
		};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// int[] A = new int[5];
		// int[] B = new int[5];
		for(int t=0; t<T; t++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    String a = st.nextToken();
		    String b = st.nextToken();
		    int alen = a.length();
		    int blen = b.length();
		    int maxlen = alen;
		    int minlen = blen;
		    String minStirng = a;
		    String maxStirng = b;
		    if(alen < blen) {
			maxlen = blen; // 5
			minlen = alen; // 4
			minStirng = a; // 9881
		    } else if (alen > blen) {
			maxlen = alen;
			minlen = blen;
			minStirng = b;
		    }

		    int ans = 0;
		    for(int i=minlen-1; i>=0; i--) {
			for(int j=0; j<7; j++) {
			    if(
				numNeon[Integer.parseInt(""+minStirng.charAt(i))][j] != 
				numNeon[Integer.parseInt(""+maxStirng.charAt(i+(maxlen-minlen)))][j]
			    ) {
				ans++;
			    }
			}
		    }

		    for(int i=0; i<(maxlen-minlen); i++) {
			for(int j=0; j<7; j++) {
			    if(numNeon[Integer.parseInt(""+maxStirng.charAt(i))][j]) {
				ans++;
			    }
			}
		    }
		    System.out.println(ans);
		}
	}
}
