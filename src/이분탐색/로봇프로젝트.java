package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇프로젝트 {
	/*
	 * 이분탐색으로 풀었더니 시간초과 ㅎㅎ.......................
	 * 이분탐색 : 이분 탐색을 하기 위해서 배열은 반드시 정렬되어 있어야 한다
	 */

	static int[] blocks;
	static boolean[] check;
	static int max;
	static int[] res;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while (str != null) {
			int x = Integer.parseInt(str);
			int n = Integer.parseInt(br.readLine());
			blocks = new int[n];
			check = new boolean[n];
			for (int i = 0; i < n; i++) {
				blocks[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(blocks);

			max = -1;
			res = new int[2];
			for (int i = 0; i < n; i++) {
				if (!check[i]) {
					binary(i, (x * 10000000) - blocks[i], 0, n - 1);
				}
			}

			Arrays.sort(res);

			String ans = "";
			if (res[0] == 0) {
				ans = "danger";
				System.out.println(ans);
			} else {
				ans = "yes";
				System.out.println(ans + " " + res[0] + " " + res[1]);
			}
		}
	} // main

	static void binary(int i, int key, int left, int right) {
		if (left > right)
			return;

		int mid = (left + right) / 2;

		if (i != mid && blocks[mid] == key) {
			check[mid] = check[i] = true;
			if (max < Math.abs(blocks[mid] - blocks[i])) {
				max = Math.abs(blocks[mid] - blocks[i]);
				res[0] = blocks[mid];
				res[1] = blocks[i];
			}
		} else if (blocks[mid] < key) {
			binary(i, key, mid + 1, right);
		} else {
			binary(i, key, left, mid - 1);
		}

	}

}
//10
//5
//1
//49999999
//50000000
//50000000
//50000000
