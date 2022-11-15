package DFS;

import java.util.Scanner;

// 20164
public class Main {

	static int N, max, min, ans;
//	static String str;

	public static void main(String[] args) throws NumberFormatException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String str = "";
		ans = 0;
		max = 0;
		min = Integer.MAX_VALUE;

		search(N);
		
//		System.out.println(min +" "+ max);

		
	} // main

	static void search(int N) {
		String str = String.valueOf(N);
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int tmp = str.charAt(i) - '0';
			if (tmp % 2 != 0)
				ans++;
		}
		
		if (len == 1) {
			System.out.println(ans);
//			max = Math.max(max, ans);
//			min = Math.min(min, ans);
			return;
		}
		

		switch (len) {
			case 2:
				int fr = N / 10;
				int ba = N % 10;
				N = fr + ba;
				search(N);
				break;
			default:
				// 0 1 19
				for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
						if(i == j) continue;
						for(int k=0; k<len; k++) {
							if(i == k || j == k) continue;
							String st1 = str.substring(i,j);
							String st2 = str.substring(j,k);
							String st3 = str.substring(k,len);
//							System.out.println(st1+st2+st3);
							N = Integer.parseInt(st1) + Integer.parseInt(st2) + Integer.parseInt(st3);
							search(N);
							for (int p = 0; p < len; p++) {
								int tmp = str.charAt(p) - '0';
								if (tmp % 2 != 0)
									ans--;
							}
						}
					}
				}
				break;
		}

	}

}
