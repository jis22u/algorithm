package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class baek17413 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int len = str.length();

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while (i < len) {
			if (str.charAt(i) != ' ' && str.charAt(i) != '<' && str.charAt(i) != '>') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == ' ') {
				while (!(stack.isEmpty())) {
					sb.append(stack.pop());
				}
				sb.append(str.charAt(i));
			} else if (str.charAt(i) == '<') {
				if (!(stack.isEmpty())) {
					while (!(stack.isEmpty())) {
						sb.append(stack.pop());
					}
				}
				while (str.charAt(i) != '>') {
					sb.append(str.charAt(i));
					i++;
				}
				sb.append(str.charAt(i));
			}

			if (i == len - 1 && !(stack.isEmpty())) {
				while (!(stack.isEmpty())) {
					sb.append(stack.pop());
				}
			}

			i++;

		}

		bw.write(sb + "");
		bw.flush();
		bw.close();
		br.close();

	} // main

}
