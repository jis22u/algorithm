import java.util.*;

public class 정수a를k로만들기 {

	static class Node {
		int value, cnt;
		
		Node(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int K = sc.nextInt();
		
		sc.close();

		boolean[] visited = new boolean[K*2];
		
		// 너비 우선 탐색으로 풀어보기
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(A+1, 1));
		q.add(new Node(A*2, 1));
		
		visited[A+1] = visited[A*2] = true;
		
		char[] c = {',', '+', '*'};
		
		while(true) {
			Node n = q.poll();
			
			if(n.value == K) {
				System.out.println(n.cnt);
				break;
			}
			
			for(int i = 1; i<=2; i++) {
				int nv = 0;
				if(c[i] == '+') { nv = n.value + 1; } 
				else { nv = n.value * 2; }
				
				if(nv > K) continue;
				if(visited[nv]) continue;
				
				visited[nv] = true;
				q.add(new Node(nv, n.cnt+1));
			}
		}
	}
}
