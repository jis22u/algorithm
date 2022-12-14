package 문자열;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// 백준 5052
// 문자열 정렬은 숫자 정렬과 결과가 다르다.
// 문자로 인식된 값은 오름차순 정렬을 한다.
// 다 가나 다라 나 가 -> 가 가나 나 다 다라 
public class 전화번호목록 {

	static int N;
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		/**
		 * 문자열 정렬의 특징을 이용한다. 
		 * 정렬 후 다음 숫자와 비교한다.
		 */

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			// N 전화번호 목록 개수
			N = sc.nextInt();
			// N개 입력 받기
			arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next();
			}

			// 문자열 정렬
			Arrays.sort(arr);

			// 일관성 조사 후 답 출력
			String ans = "NO";
			if (isValid()) ans = "YES";

			System.out.println(ans);
		}
	} // main

	// 일관성 조사
	static boolean isValid() {
		for (int i = 0; i < N - 1; i++) {
			String str1 = arr[i];
			int len1 = str1.length();
			String str2 = arr[i + 1];
			int len2 = str2.length();
			
			// 동일한 char을 공유하고 있다면 참
			boolean same = true;
			
			// 길이가 짧은 것을 기준으로 비교하면 되기 때문에
			if (len1 <= len2) {
				// str1의 길이가 짧거나 둘의 길이가 같다면
				for (int j = 0; j < len1; j++) {
					if (str1.charAt(j) != str2.charAt(j)) {
						// char이 중복되지 않다면
						same = false;
					}
					// 여기에 위치해있으면 안됨
					// 아직 한 문자열의 모든 char를 검사하지 않은채 결론지어버림 
					// if(same) return false;
				}
			} else {
				// str2의 길이가 짧다면
				for (int j = 0; j < len2; j++) {
					if (str1.charAt(j) != str2.charAt(j)) {
						same = false;
					}
				}
			}
			
			// 각 char들을 모두 검사 후 중복되는 것이 있다면 일관성 없음
			if(same) return false;
		}
		
		// 위의 모든 검사를 통과했다면 일관성 있음
		return true;
	}
}
