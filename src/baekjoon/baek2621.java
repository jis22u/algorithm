package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek2621 {

	static String[] color;
	static int[] num;
	static int[] numCnt;
	static int[] colorCnt;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 순서대로 어떤 종류?
		color = new String[5];
		num = new int[5];
		// 몇 개 들어왔는지
		colorCnt = new int[4];	//0:R 1:B 2:Y 3:G
		numCnt = new int[10];

		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			color[i] = st.nextToken();
			num[i] = Integer.parseInt(st.nextToken());
			
			if(color[i].equals("R")) {
				colorCnt[0]++;
			} else if(color[i].equals("B")) {
				colorCnt[1]++;
			} else if(color[i].equals("Y")) {
				colorCnt[2]++;
			} else {
				colorCnt[3]++;
			}
			
			numCnt[num[i]]++;
		}
		
		// 가장 높은 숫자 구하기
		int idx = 0;
		for (int i = 9; i >= 1; i--) {
			if (numCnt[i] > 0) {
				idx = i;
				break;
			}
		}
		
		// ans 구하기
		int ans = 0;
		if(isSameColor() && isSerial()) {
			// 1번. 카드 5장 모두 같은 색 & 숫자가 연속적
			ans = 900 + idx;
		} else if(isSameColor()) {
			// 4번. 5장의 카드 색깔이 모두 같을 때
			ans = 600 + idx;
		} else if(isSerial()) {
			// 5번. 카드 5장의 숫자가 연속적일 때
			ans = 500 + idx;
		} else if(sameNum() != 0) {
			ans = sameNum();
		} else {
			ans = 100 + idx;
		}
		
		System.out.println(ans);
		br.close();
		
		
	} // main
	
	static boolean isSameColor() {
		for(int i=0; i<4; i++) {
			if (colorCnt[i] == 5) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}
	
	static boolean isSerial() {
		int[] tmp = Arrays.copyOfRange(num, 0, 5);
		Arrays.sort(tmp);
		for(int i=0; i<4; i++) {
			int a = tmp[i+1]-tmp[i];
			if(a != 1) {
				return false;
			}
		}
		return true;
	}
	
	static int sameNum() {
		for(int i=1; i<10; i++) {
			if(numCnt[i] == 4) {
				// 2번. 카드 5장 중 4장의 숫자가 같을 때
				return (800 + i);
			} else if(numCnt[i] == 3) {
				for(int j=1; j<10; j++) {
					if(numCnt[j] == 2) {
						// 3번. 카드 5장 중 3장의 숫자, 나머지 2장도 숫자가 같을 때
						return i * 10 + j + 700;
					} else if (numCnt[j] == 1) {
						// 6번. 카드 5장 중 3장의 숫자가 같을 때
						return 400 + i;
					}
				}
			} else if(numCnt[i] == 2) {
				int cnt=0;
				for(int j=1; j<10; j++) {
					if(numCnt[j] >0) cnt++;
				}
				
				if(cnt == 3) {
					for(int j=1; j<10; j++) {
						if(i!=j && numCnt[j] == 2) {
							// 7번. 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때
							int a = Math.max(i, j);
							int b = Math.min(i, j);
							return 10 * a + b + 300;
						}
					}
				} else if(cnt == 4) {
					// 8번. 카드 5장 중 2장의 숫자가 같을 때(2,1,1,1)
					return 200 + i;
				}
			}
		}
		return 0;
	}

} // end class