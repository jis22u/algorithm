package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 수찾기 {

	static int[] X,A;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		X = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}
		
		// A값들에서 X값 있는지 찾아라
		// 순서대로 하나씩 다 검사하면 시간초과 날것임
		// 문제가 그럴거같음 짜증난다
		Arrays.sort(A);
		
		// ㅇ;분탐색할라고 정렬한다
		
		for(int i=0; i<M; i++) {
			이분탐색(X[i], 0, N-1);
		}
	} //main
	
	static void 이분탐색(int target, int left, int right) {
		if(left > right) {
			System.out.println(0);
			return;
		}
		
		int mid = (left + right)/2;
		if(A[mid] > target) {
			이분탐색(target, left, mid-1);
		} else if(A[mid] < target) {
			이분탐색(target, mid+1, right);
		} else {
			System.out.println(1);
			return;
		}
		
	}

}
