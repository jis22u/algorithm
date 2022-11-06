package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_PASS {
	
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
		check[N] = true;
		
		int ans = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int nx = n.x;
			
			if(nx == K) {
				ans = n.t; 
				break;
			}
			
			// 내가 들어갈 곳의 좌표를 미리 만들어주고
			// 거기 범위 넘어가? 이미 방문한 적 있어? 체크하는 것
			// 틀린 코드는 먼저 들어가놓고 여기 방문한 적 있어? 범위 넘어가? 체크한 것
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
