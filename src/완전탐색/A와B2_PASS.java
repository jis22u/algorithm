package 완전탐색;

import java.util.Scanner;

public class A와B2_PASS {

	static String S, T;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.next();
		T = sc.next();
		ans = 0;

		search(T);

		System.out.println(ans);
	} // main

	static void search(String str) {
		if (str.length() == S.length()) {
			// 찾았다
			if (str.equals(S)) {
				ans = 1;
			}
			return;
		}

		if (str.length() < S.length()) {
			return;
		}

		if (str.charAt(str.length() - 1) == 'A') {
			String tmp = str;
			tmp = tmp.substring(0, tmp.length() - 1);
			search(tmp);
		}

		if (str.charAt(0) == 'B') {
			String tmp = str;
			StringBuilder sb = new StringBuilder();
			sb.append(tmp).reverse();
			sb.delete(sb.length() - 1, sb.length());
			search(sb.toString());
		}
	}

}