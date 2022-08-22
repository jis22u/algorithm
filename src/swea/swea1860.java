package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// *** 입장을 다르게 생각해보면 코드가 더 간결해질 수 있다 ***
public class swea1860 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			// 손님 수 & 붕어빵
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			// 손님 배열
			// 인덱스가 몇 초인지를 나타냄
			// 초마다 들어오는 손님수 카운트
			int[] guest = new int[11112];
			st = new StringTokenizer(br.readLine());
			int time;
			for(int i=0; i<n; i++) {
				time = Integer.parseInt(st.nextToken());
				guest[time]++;
			}
			
			
			int cnt=0;	// 붕어빵 개수
			int p=0;	// 붕어빵 받은 손님

			
			// 0초라는 건 아직 오픈 전
			if(guest[0]>0) {
				System.out.println("#"+t+" "+"Impossible");
			} else {
				// 이때부터 i(시간)가 +1 하면서
				// 붕어빵 cnt, 붕어빵 받은 손님 p 변화
				int i=1;
				while(i<11112) {
					// 붕어빵 카운트
					if(i%m == 0) {
						cnt += k;
					}
					
					// 나는 가게 주인 입장에서 생각
					// 붕어빵 받은 손님수 카운트
					if(guest[i] != 0) {
						cnt -= guest[i];
						if(cnt >=0) {
							p += guest[i];
							if(p == n) {
								System.out.println("#"+t+" "+"Possible");
								break;
							}
						} else {
							System.out.println("#"+t+" "+"Impossible");
							break;
						}
					}
					
					// 시간변화
					i++;
				}
			}
		} //for
		
	} // main

}
