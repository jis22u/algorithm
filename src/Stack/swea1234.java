package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


// swea비밀번호
public class swea1234 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			int len = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < len; i++) {
				if(!stack.isEmpty()) {
					if(stack.peek() == str.charAt(i)) {
						stack.pop();
					} else {
						stack.push(str.charAt(i));
					}
				} else {
					stack.push(str.charAt(i));
				}
			}
			
			sb.append("#"+t+" ");
			for(int i=0;i<stack.size();i++) {
				sb.append(stack.get(i));
			}
			sb.append("\n");
			
			System.out.print(sb);
		}
	} // main

}
