package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class baek1343 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String str = sc.next().replace("X", "B");
		
		int len = str.length();
		int cnt = 0;
		boolean flag = true;
		loop:
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'B') {
				cnt++;
			} 
			if (i == len-1 || str.charAt(i) == '.') {
				if(cnt%2==0) {
					if(cnt >= 4) {
						str = str.replace("BBBB", "AAAA");
					} 
				} else {
					flag = false;
					break loop;
				}
				cnt = 0;
			} 
		}

		if (flag) {
			System.out.println(str);
		} else {
			System.out.println(-1);
		}
		
		
		// 그냥 이렇게 풀면 되는구나...
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		str = str.replace("XXXX", "AAAA");
//		str = str.replace("XX", "BB");
//		if (str.contains("X")) {
//			System.out.println(-1);
//		} else {
//			System.out.println(str);
//		}
		
		
	} // main
}