package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2816 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[][] arr = new String[n + 1][1];
		int kbs1 = 0;
		int kbs2 = 0;
		
		for (int i = 1; i < n + 1; i++) {
			arr[i][0] = br.readLine();

			if (arr[i][0].equals("KBS1")) {
				kbs1 = i;
			} else if (arr[i][0].equals("KBS2")) {
				kbs2 = i;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < kbs1; i++) {
			sb.append("1");
		}
		for (int i = 1; i < kbs1; i++) {
			sb.append("4");
		}

		if (kbs1 < kbs2 || kbs2==1) {
			for (int i = 1; i < kbs2; i++) {
				sb.append("1");
			}

			for (int i = 1; i < kbs2 - 1; i++) {
				sb.append("4");
			}
		} else {
			for (int i = 1; i < kbs2+1; i++) {
				sb.append("1");
			}

			for (int i = 1; i < kbs2; i++) {
				sb.append("4");
			}
		}

		System.out.println(sb);
		br.close();

	} // main

}
