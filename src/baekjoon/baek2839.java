package baekjoon;

import java.util.Scanner;


// 영묵님 코드 반영..
// 그리디 알고리즘!!!!!
// 가장 핵심 조건. 봉지의 '최소' 개수
//				   최대한 적게 가져가는 경우
public class baek2839 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int ans = 0;
			
		if(num % 5 == 0) {
			ans =  num / 5;
		} else {
			int tmp = num;
			while(true) {
				tmp -= 3;
				ans++;
				if(tmp%5 == 0) {
					ans += (tmp/5);
					break;
				} else if (tmp == 1 || tmp == 2){
					ans = -1;
					break;
				} else if (tmp == 0){
					break;
				}
			}
		} 
		
		System.out.println(ans);
		sc.close();

	} // main

}
