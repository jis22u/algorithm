package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 100부터 999까지를 포함하는 boolean 배열을 만들어
		// 100부터 999까지 완전탐색할거야
		
		// 민혁이가 질문한 횟수만큼 반복문을 돌려
		// 여기서 스트라이크, 볼 인지를 판단할거야
		// 조건에 맞지 않는 인덱스(숫자)는 false 처리
		// 		먼저 문자열 인덱스를 이용해서 비교할 것이기 때문에 숫자>String으로 바꿔주는 작업이 필요
		//		스트라이크인 경우는 문자열의 0번 인덱스 1번 인덱스 2번 인덱스 동일한 인덱스
		//		볼인 경우는 contains 함수 활용
		//		민혁이가 질문한 경우의 수를 모두 만족하는 인덱스여야 함 
		//		마지막 경우에서 true를 처리
		// 		중간에 조건에 맞지 않는 인덱스가 나올 경우 continue???? break???
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int Y = Integer.parseInt(br.readLine());

		String[] min = new String[Y];
		int[][] young = new int[Y][2];
		for(int i=0; i<Y; i++) {
			st = new StringTokenizer(br.readLine());
			min[i] = st.nextToken();
			for(int j=0; j<2; j++) {
				young[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int sCnt = 0;
		int bCnt = 0;
		boolean[] ans = new boolean[1000];
		for(int i=111; i<1000; i++) {
			String str = String.valueOf(i);
			
			loop:
			for(int j=0; j<Y; j++) {
				sCnt = 0;
				bCnt = 0;
				for(int k=0; k<3; k++) {
					// 스트라이크?
					if(str.charAt(k) == min[j].charAt(k)) {
						sCnt++;
					}
					// 볼?
					else if(str.contains(min[j].charAt(k)+"")){
						bCnt++;
					}
				}
				
				if(sCnt == young[j][0] && bCnt == young[j][1]) {
					ans[i] = true;
				} else {
					ans[i] = false;
					break loop;
				}
			}
		}
		
		
		int cnt = 0;
		for(int i=111; i<1000; i++) {
			String str = String.valueOf(i);
			if(ans[i] && !str.contains("0") && str.charAt(0) != str.charAt(1) && str.charAt(0) != str.charAt(2) && str.charAt(1) != str.charAt(2)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		br.close();
		
		
	} //main

}
