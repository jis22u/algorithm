package DFS;

import java.util.Scanner;

// 20164
// 백준 - 홀수 홀릭 호석
public class 홀수홀릭호석 {

	static int max, min;

	public static void main(String[] args) throws NumberFormatException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		max = 0;
		min = Integer.MAX_VALUE;

		search(N, ans);

		System.out.println(min + " " + max);

	} // main

	static void search(int N, int ans) {
		String str = String.valueOf(N);
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int tmp = str.charAt(i) - '0';
			if (tmp % 2 != 0)
				ans++;
		}

		switch (len) {
		case 1:
			max = Math.max(ans, max);
			min = Math.min(ans, min);
//				System.out.println(ans);
			break;
		case 2:
			int fr = N / 10;
			int ba = N % 10;
			N = fr + ba;
			search(N, ans);
			break;
		default:
			// 5 1 4 5
			for (int i = 0; i <= len - 3; i++) {
				for (int j = i+1; j <= len - 2; j++) {
					String st1 = str.substring(0, i+1);
					String st2 = str.substring(i+1, j+1);
					String st3 = str.substring(j+1, len);
					N = Integer.parseInt(st1) + Integer.parseInt(st2) + Integer.parseInt(st3);
					search(N, ans);
				}
			}
			break;
		}

	}

}
