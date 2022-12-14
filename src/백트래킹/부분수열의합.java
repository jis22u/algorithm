package 백트래킹;

import java.util.Scanner;


// 부분집합 재귀함수
public class 부분수열의합 {

	static int N,S,cnt;
	static boolean[] check;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		cnt=0;
		power(0);
		if(S == 0) {
			cnt--;
		}
		System.out.println(cnt);
	} //main
	
	
	static void power(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(check[i]) {
					sum += arr[i];
				}
			}
			if(sum == S) {
				cnt++;
			}
			return;
		}
		
		check[idx] = false;
		power(idx+1);
		check[idx] = true;
		power(idx+1);
	}
}
