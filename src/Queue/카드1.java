import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		// 큐 배열 생성 후 큐에 1부터 N까지의 정수 넣기
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		// 정답 저장
		StringBuilder sb = new StringBuilder();

		while(q.size() > 1) { // 큐 사이즈가 2개 이상일 때
			sb.append(q.poll()).append(" ");	// 카드 바닥에 버리고
			q.add(q.poll());					// 아래에 다시 넣고
		}
		System.out.println(sb.append(q.poll()).toString());
	}
}
