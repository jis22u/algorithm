package DFS;

// 여러 가지 sum의 값 자체를 dfs로 넘김
// 넘기면서 계산
public class 타겟넘버_PASS {

	static int answer;
	public static void main(String[] args) {
		int[] numbers = { 4, 1, 2, 1 };
		int target = 4;

		answer = 0;
		dfs(0, numbers, target, 0);
		System.out.println(answer);
	}

	static void dfs(int idx, int[] numbers, int target, int sum) {
		if (idx == numbers.length) {
			System.out.println(sum);
			if (sum == target) {
				answer++;
			}
			return;
		}
		
		
		dfs(idx + 1, numbers, target, sum + numbers[idx]);
		dfs(idx + 1, numbers, target, sum - numbers[idx]);
	}

}
