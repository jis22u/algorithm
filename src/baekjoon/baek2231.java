package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		boolean flag = false;
		for(int n=1; n<=1000000; n++) {
			int ans = n;
			int tmp = n;
			int a = 0;
			while(tmp != 0) {
				a = tmp%10;
				tmp = tmp/10;
				ans += a;
			}
			
			if(ans == num) {
				System.out.println(n);
				flag = true;
				break;
			} 
		}
		
		if(!flag){
			System.out.println(0);
		}
		
		
	} //main

}
