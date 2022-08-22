package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 - 슈퍼마리오
public class baek2851 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum= 0;
		int minus=100;
		int ans = 0;
		
		for(int i=0; i<10; i++) {
			sum += Integer.parseInt(br.readLine());

			// 변곡점: |합계-100|이 작아지다가 커지는 순간
			// 변곡점 이후에 작동을 하는 게 아니라
			// 변곡점 이전까지 작동하다가 이후엔 작동하지 못하도록
			// 변곡점 이전까지 작동하면서 나오는 정답은 변수에 저장해두기
			// 변곡점 이후엔 작동하지 않을 것이기 때문에 정답이 변할일 없음
			if(minus >= Math.abs(sum-100)) {
				minus = Math.abs(sum-100);
				ans = sum;
			}
		
		}
		
		System.out.println(ans);
		
		
		
		// 틀린 코드
		// 아래의 코드는 변곡점이 발생하지 않는 순간엔 정답이 나오지 않는다
		// 즉 버섯 10개를 다 더해도 100이 되지 않는 경우이다.
//		int[] m = new int[10];
//		int[] minus = new int[10];
//		int sum= 0;
//		
//		for(int i=0; i<10; i++) {
//			m[i] = Integer.parseInt(br.readLine());
//			sum += m[i];
//			minus[i] = Math.abs(sum-100);
//		}
//		
//		for(int i=1; i<10; i++) {
//			if(minus[i-1] == minus[i]) {
//				System.out.println(minus[i]+100);
//				break;
//			} else if(minus[i-1]<minus[i]) {				//여기가 변곡점
//				System.out.println(100-minus[i-1]);
//				break;
//			} else {
//				continue;
//			}
//		}
		

	} // main

}