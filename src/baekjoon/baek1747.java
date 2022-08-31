package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek1747 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		// 소수 판별
		boolean[] prime = new boolean[2000000];
		prime[0] = true;
		prime[1] = true;
		for(int i=2; i<2000000; i++) {
			if(!prime[i]) {
				for(int j=i*2; j<2000000; j += i) {
					prime[j] = true;
				}
			}
		}
		
		
		// 팰린드롬 판별
		// 컴퓨터는 사람이 계산하듯 '1+ 2*10 +3*100' 계산하지 않는다.
		// 처음 1을 구했다면 1, 그 다음 1*10에 2를 더하고, 그 다음 12*10에 3을 더한다.
		// 중간중간 값이 기억된다는 점, 계속 반복하면서 자리를 하나씩 늘려간다는 점.
		// 사람이 계산하듯 하지 않는다.
		int ans=0;
		for(int i=num; i< 2000000; i++) {
			if(!prime[i]) {
				int tmp=i;
				ans=0;
				while(tmp>0) {
					ans = (ans*10) + (tmp%10);
					tmp= tmp/10;
				}
				if(ans == i) {
					ans = i;
					break;
				}
			}
		}
		
		System.out.println(ans);
		br.close();
		
	} //main

}
