package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek20546 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] stock = new int[14];
		for (int i = 0; i < 14; i++) {
			stock[i] = Integer.parseInt(st.nextToken());
		}

		// 준현 BNP
		int jCash = m;
		int jStock = 0;
		for (int i = 0; i < 13; i++) {
			if (jCash >= stock[i]) {
				jStock += jCash / stock[i];
				jCash = jCash % stock[i];
			}
		}

		jCash += jStock * stock[13];

		// 성민 TIMING
		int sCash = m;
		int sStock = 0;
		int cntP = 0;
		int cntM = 0;
		for (int i = 0; i < 12; i++) {

			if (stock[i] < stock[i + 1]) {
				cntP++;
			} else {
				cntP = 0;
			}

			if (stock[i] > stock[i + 1]) {
				cntM++;
			} else {
				cntM = 0;
			}

			if (cntP == 3) {
				// 매도
				sCash += stock[i + 1] * sStock;
				sStock = 0;
			}

			if (cntM >= 3 && sCash > stock[i + 1]) {
				// 매수
				sStock += sCash / stock[i + 1];
				sCash = sCash % stock[i + 1];
			}
		}

		sCash += sStock * stock[13];

		
		if(jCash > sCash) {
			System.out.println("BNP");
		} else  if(jCash < sCash){
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	} // main

}
