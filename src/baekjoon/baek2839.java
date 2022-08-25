package baekjoon;

import java.util.Scanner;

public class baek2839 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int m = n; // n값
		int a; // 몫
		int b = -1; // 나머지

		int cnt = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		int ans = 0;
		loop: while (b != 0) {
			if (m % 5 == 0) {
				ans = m / 5;
				b = m % 5;
			} else {
				ans = m / 5;
				m = m % 5;
				if (m % 3 == 0) {
					ans += m / 3;
					b = m % 3;
				} else {
//					cnt2 = -1;
					break loop;
				}
			}
		}
		
		b = -1;
		loop: while (b != 0) {
			if (m % 3 == 0) {
				cnt = n / 3;
				b = m % 3;
			} else {
				cnt = m / 3;
				m = m % 3;
				if (m % 5 == 0) {
					cnt += m / 5;
					b = m % 5;
				} else {
//					cnt2 = -1;
					break loop;
				}
			}

		}
		if (cnt2 == -1) {
			System.out.println(-1);
		} else {
//			int min = Math.min(cnt, ans);
			System.out.println(cnt);
			System.out.println(ans);
		}
	} // main

}
