package 백트래킹;

/**
 * 첫번째 시도........
 * N자리 수의 모든 수 중에서 1, 2, 3으로만 구성된 수 찾아서 좋은 수열인지 판별
 * 일단 채점에서 틀리기도 했고, N이 9만 돼도 답이 바로 안나온다.
 */

/**
 * 두번째 시도
 * 몰라.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은수열 {
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		backtracking("");
	}

	private static void backtracking(String result) {
		if (result.length() == N) {
			System.out.println(result);
			System.exit(0); // 현재 실행하고 있는 프로세스를 강제 종료

		} else {
			for (int i = 1; i <= 3; i++) {
				if (isGoodSequence(result + i)) {
					backtracking(result + i);
				}
			}
		}
	}

	private static boolean isGoodSequence(String s) {
		int length = s.length() / 2;

		for (int i = 1; i <= length; i++) {
			if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
				return false;
			}
		}

		return true;
	}
}
