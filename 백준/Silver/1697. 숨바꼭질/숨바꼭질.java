import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Node {
		int x;
		int t;
		Node(int x, int t) {
			this.x = x;
			this.t = t;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean[] check = new boolean[100001];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N, 0));
		
		int ans = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int nx = n.x;
			
			if(nx == K) {
				ans = n.t; 
				break;
			}
			
			if(nx-1>=0 && !check[nx-1]) {
				q.add(new Node(nx-1, n.t+1));
				check[nx-1] = true;
			} 
			if(nx+1<100001 && !check[nx+1]) {
				q.add(new Node(nx+1, n.t+1));
				check[nx+1] = true;
			} 
			if(nx*2<100001 && !check[nx*2]) {
				q.add(new Node(nx*2, n.t+1));
				check[nx*2] = true;
			}
		}
		
		ans=(N==K? 0 : ans);
		System.out.println(ans);
		
	} //main
}