package BFS;

// BFS로 풀림
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3 {

	static class Node {
		// x:수빈이의 위치, t: 걸린 시간
		int x;
		int t;
		
		Node (int x, int t) {
			this.x = x;
			this.t = t;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		// N: 수빈 K: 동생
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		// 이동한 위치는 더이상 볼 필요 없음
		boolean[] visited = new boolean[100001];
		// 위치와 걸린 시간 정보가 담긴 Node를 담을 Queue
		Queue<Node> queue = new LinkedList<>();
		// 일단 현재 위치 N에서 출발
		queue.add(new Node(N,0));
		visited[N] = true;
		// 정답
		int ans = 0;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(n.x == K) {
				ans = n.t;
				break;
			}
			
			// 순간이동
			if(n.x*2 < 100001 && !visited[n.x*2]) {
				visited[n.x*2] = true;
				queue.add(new Node(n.x*2, n.t));
			}
			
			// 뒤로 한 칸 이동
			if(n.x-1 >= 0 && !visited[n.x-1]) {
				visited[n.x-1] = true;
				queue.add(new Node(n.x-1, n.t+1));
			}
			
            // 앞으로 한 칸 이동
			if(n.x+1 < 100001 && !visited[n.x+1]) {
				visited[n.x+1] = true;
				queue.add(new Node(n.x+1, n.t+1));
			}
		}
		
		System.out.println(ans);
	} // main

}
