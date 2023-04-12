import java.util.*;

public class N개의최소공배수 {
	public static void main(String[] args) {

		int[] arr = {2, 6, 8, 14};

		// arr 정렬
		Arrays.sort(arr);
		// arr 배열의 길이
		int len = arr.length;
		// 정답
		int answer = 0;

		for (int i = 1; ; i++) {
			// 가장 큰 수의 배수 탐색
			int num = arr[len - 1] * i;

			// 나머지 원소들로 나눠서 나머지가 모두 0이면 해당 원소의 최소공배수로도 적합
			boolean flag = true;
			for (int j = 0; j < len - 1; j++) {
				if (num % arr[j] != 0) {
					flag = false;
				}
			}

			// flag가 T이면, 모든 원소가 해당 num을 최소공배수로 갖고 있는 것
			if (flag) {
				answer = num;
				break;
			}
		}

		System.out.println(answer);
	}
}
