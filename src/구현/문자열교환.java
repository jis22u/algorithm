package 구현;

import java.util.Scanner;

public class 문자열교환 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] ccc = str.toCharArray();
		int len = ccc.length;
		int cnt = 0;
		// b 개수 세어주ㅡㅏㅓ
		for (int i = 0; i < len; i++) {
			if (ccc[i] == 'b') {
				cnt++;
			}
		}

		int min = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < cnt; j++) {
				if (ccc[(i + j) % len] == 'a') {
					ans++;
				}
			}
			
			min = Math.min(ans, min);
			ans = 0;
		}

		System.out.println(min);
	}

}
