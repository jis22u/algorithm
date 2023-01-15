package 완전탐색;

import java.util.Scanner;

// 프로그래머스
public class 카펫 {

	public static void main(String[] args) {
		/**
		 * 브라운 + 옐로우를 합친 수의 약수 구하기 
		 * 가로 >= 세로 를 만족하도록 가로, 세로 값을 할당하고
		 * 옐로우가 들어갈 공간을 찾는다
		 * 		(세로-2) * (가로-2) == 옐로우의 수를 만족하면 
		 * 		정답 break 걸고 답 출력
		 */
		Scanner sc = new Scanner(System.in);

		int brown = sc.nextInt();
		int yellow = sc.nextInt();

		int sum = brown + yellow;

		// 브라운 + 옐로우를 합친 수의 약수 구하기
		int w = 0;
		int h = 0;
		for (int i = 2; i < sum; i++) {
			if (sum % i == 0) {
				// 가로 >= 세로 를 만족하도록
				h = i;
				w = sum / i;

				if ((h - 2) * (w - 2) == yellow) {
					break;
				}
			}
		}

		int[] answer = { w, h };
		
		System.out.println(w+" " +h);

	}

}
