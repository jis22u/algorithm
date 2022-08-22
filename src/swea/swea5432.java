package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 쇠막대기 자르기
// 1. 공통점을 뽑아내자
// 2. 컴퓨터는 왼쪽에서 오른쪽으로
// 	  즉, 이미 '완료'된 상태에서 '일괄적으로' 한 방향으로 움직여 생각한다
//	  시림처럼 쌓이는 '과정'을 생각하지 못한다.
public class swea5432 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int stick=0;
			int ans=0;
			
			String str = br.readLine();
			int len = str.length();
			
			for(int i=0; i<len; i++) {
				
				if(str.charAt(i) == '(' && str.charAt(i+1) == ')') {
					ans += stick;
				} else if(str.charAt(i) == '(') {
					stick++;
				} else if(str.charAt(i-1) != '(' && str.charAt(i) == ')') {
					stick--;
					ans++;
				}
				
			}
			
			bw.write("#"+t+" "+ans);
			bw.newLine();
			
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	} //main

}
