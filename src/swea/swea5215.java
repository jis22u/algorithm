package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea5215 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int[] scores = new int[n];
			int[] cal = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}

			
			int sumCal =0;
			int sumSco =0;
			int max = 0;
			// (1 << n) 부분집합의 개수 = 모든 경우의 수를 검사하겠다
			for (int i = 0; i < (1 << n); i++) {
				sumCal =0;
				sumSco =0;
				// 근데 어떤 원소를 가지고 있는 부분집합이야?
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) > 0) {
						// 해당 i 가 검사하고 싶은 경우의 수
						// 뒤에서부터 하나씩 검사, 비교해서 0보다 크면 해당 j번째 원소 선택
						sumCal += cal[j];
						sumSco += scores[j];
					}
				}
				
				if(sumCal<=l && sumSco > max) {
					max = sumSco;
				}
			}

			System.out.println("#"+t+" "+max);
		}

	} //main

}
