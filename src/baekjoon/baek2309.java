package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek2309 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] h = new int[9];
		for (int i = 0; i < 9; i++) {
			h[i] = Integer.parseInt(br.readLine());
		}

		int sum = 0;
		loop:
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				for (int k = j + 1; k < 9; k++) {
					for (int l = k + 1; l < 9; l++) {
						for (int n = l + 1; n < 9; n++) {
							for (int m = n + 1; m < 9; m++) {
								for (int o = m + 1; o < 9; o++) {

									sum = h[i] + h[j] + h[k] + h[l] + h[n] + h[m] + h[o];
									if (sum == 100) {
										int[] ans = { h[i], h[j], h[k], h[l], h[n], h[m], h[o] };
										Arrays.sort(ans);
										for(int a:ans) {
											System.out.println(a);
										}
										break loop;
									}
								}

							}
						}
					}
				}
			}
		}

	} // main

}