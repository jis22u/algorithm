package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 회전초밥 {

	/**
	 * 슬라이딩 윈도우 
	 * 투포인터랑 비슷하게 st,ed 이용하는데 st부터 ed까지 범위로(통으로) 움직임
	 * 1) set 이용했는데, set은 인덱스 상관없이 원소가 있으면 무조건 지움
	 * 순서가 유지되지 않음.
	 * 배열 이용해서 풀어야할 듯..그래서 d를 알려줬구나...
	 * 2) T/F 판별로도 안돼ㅗㅗㅗㅗㅗㅗ
	 * 
	 */
	static int[] select;
	static int N,d,c, arr[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// N: 접시의 수, d: 초밥의 가짓수, k:연속 접시의 수, c: 쿠폰 번호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stz.nextToken());
		d = Integer.parseInt(stz.nextToken());
		int k = Integer.parseInt(stz.nextToken());
		c = Integer.parseInt(stz.nextToken());

		arr = new int[N];
		// 스시~~~
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 선택한 스시 체크
		select = new int[d+1];

		// 먼저 k개 넣고 시작
		for(int i=0; i<k; i++) {
			select[arr[i]]++;
		}
		
		// (i + k) % N
		// 스시를 k개 골라보자
		// st부터 ed까지 통으로 움직여 > 슬라이딩 윈도우
		int ans = 0;
		for (int i = 0; i < N; i++) {
			
			select[arr[i]]--;
			select[arr[(i+k)%N]]++;
			
			
			if(ans <= cntTrue()) {
				// c가 선택된적 없으면
				if(select[c] == 0) {
					select[c]++;
					ans = cntTrue();
				} else {
					ans = cntTrue();
				}
			} 
		}
		
		
 		System.out.println(ans);

	}
	
	static int cntTrue() {
		int cnt = 0;
		for(int j=1; j<d+1; j++) {
			if(select[j] >= 1) {
				cnt++;
			}
		}
		return cnt;
	}

}
