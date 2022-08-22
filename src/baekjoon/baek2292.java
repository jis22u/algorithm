package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 벌집
// 1. 공통점을 뽑아내자
public class baek2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int honey = 1;
		
		
		if(n == 1) {
			System.out.println(1);
		} else {
			for(int i=1; ;i++) {
				if(honey+1 <= n && honey+(6*i) >= n) {
					System.out.println(i+1);
					break;
				}
				honey = honey+(6*i);
			}
		}
		
		// n을 찾아 움직인다는 느낌에서 아래의 코드가 좀 더 와닿는다.
//		int count = 1; // 겹 수(최소 루트)
//		int range = 2;	// 범위 (최솟값 기준) 
// 
//		if (n == 1) {
//			System.out.print(1);
//		}
// 
//		else {
//			while (range <= n) {				// 범위가 N보다 커지기 직전까지 반복 
//				range = range + (6 * count);	// 다음 범위의 최솟값으로 초기화 
//				count++;						// count 1 증가 
//			}
//			System.out.print(count);
//		}
		
		
	} //main

}
