package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_PASS {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		// N: 수열의 길이, S: 타겟 값
		int N = Integer.parseInt(stz.nextToken());
		int S = Integer.parseInt(stz.nextToken());
		
		// N개 수열
		stz = new StringTokenizer(br.readLine()); 
		int[] arr = new int[N+1];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		
		// N만큼 돌리는 반복문 안에 또 whle문을 돌려서 
		// 인덱스 하나씩 알아보면 시간초과
		// 한 번 탐색할 때마다 (두포인터를 움직여서) 앞,뒤를 다 살펴야함
		// 양방향으로 가능한 모든 경우의 수를 조사하는 것
		// 실패코드는 일방향으로만 찾아서 오래걸림
		
		int sum = 0;
		int st = 0;
		int ed = 0;
		int min = Integer.MAX_VALUE;
		while(st <= N && ed <= N) {
			if(sum >= S && min > ed-st) min = ed-st;
			
			if(sum < S) {
				sum += arr[ed];
				ed++;
			} else {
				sum -= arr[st];
				st++;
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
	}

}
