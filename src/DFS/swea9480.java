package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 민정이와 광직이의 알파벳 공부
public class swea9480 {

	static int[] alpha;
	static int n, cnt;
	static String[] words;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			words = new String[n];
			// 선택했는지 안했는지 체크
			check = new boolean[n];

			for (int i = 0; i < n; i++) {
				words[i] = br.readLine();
			}

			// 부분집합으로 가능한 조합 다 구하기
			cnt = 0;
			dfs(0);
			System.out.println("#" + t + " " + cnt);
		}

		br.close();

	} // main

	static void dfs(int idx) {
		// 그 조합이 모든 알파벳을 포함하고 있는지 검사
		if (idx == n) {
			// 인덱스 0 = a
			alpha = new int[26];
			for (int i = 0; i < n; i++) {
				if (check[i]) {
					for (int j = 0; j < words[i].length(); j++) {
						alpha[words[i].charAt(j) - 97]++;
					}
				}
			}

			boolean flag = true;
			for (int i = 0; i < 26; i++) {
				if (alpha[i] == 0) {
					flag = false;
					break;
				}
			}

			if (flag) cnt++;
			
			return;
		}

		check[idx] = false;
		dfs(idx + 1);
		check[idx] = true;
		dfs(idx + 1);

	} // dfs

}
