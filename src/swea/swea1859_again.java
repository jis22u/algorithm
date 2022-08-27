package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 테케 3번부터 fail..



//백만 장자 프로젝트
public class swea1859_again {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] price;

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			price = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			
			// 두번째 시도
			// 첫번째 두번째 최대값 찾아서 그때까지 사고
			// 첫번째 최대값에서 팔고 두번째 최대값까지 다시 사고 반복하고 싶은데
			// 좋은 코드가 생각나지 않는다...
			
//			// 최대값 찾기
//			int[] tmp = Arrays.copyOf(price, n);
//			Arrays.sort(tmp);
//			
//			int idx=0;
//			for(int i=n-1; i>=0; i--) {
//				if (tmp[i] == price[n-1]) {
//					idx = i;
//				}
//			}
//			int[] max = Arrays.copyOfRange(tmp, idx, n);
//			
//			int buy = 0;
//			int profit = 0;
//			int i=0;
//			int k=0;
//			while(i<n) {
//				
//				buy += 1;
//				profit -= price[i];
//				
//				if(price[i] == max[k]) {
//					profit += (buy * price[i]);
//					buy=0;
//					k++;
//				}
//				i++;
//			}
			
			
			
//			System.out.println("#"+t+" "+profit);

		}

	} // main
}

// 첫번째 시도
//  아이디어는 fail이지만... 평소에 구현하고 싶었던 로직,,
//	price 배열의 길이는 n+1로 설정한다.

//	//일단 먼저 사고
//	// 변곡점에서 팔기
//	int buy = 0;
//	int profit = 0;
//	int i=0;
//	while(i<n) {
//		// 크기가 뒤집히는 순간에 팔기
//		if(buy != 0 && price[i] >price[i+1]) {
//			profit += (buy * price[i]);
//			buy=0;
//		} else {
//			// 일단 먼저 사고
//			buy += 1;
//			profit -= price[i];
//		}
//		i++;
//	}
