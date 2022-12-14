package Stack;

import java.util.Scanner;
import java.util.Stack;

// 백준 1935
public class 후위표기식2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.next());
		String str = sc.next();
		double[] arr = new double[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Double> stack = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c-65 >= 0) {
				stack.push(arr[c-65]);
			} else {
				double a = stack.pop();
				double b = stack.pop();
				double res = 0;
				switch(c) {
					case '+' : 
						res = a + b;
						break;
					case '-' :
						res = b - a;
						break;
					case '*' :
						res = a * b;
						break;
					case '/' :
						res = b / a;
						break;
				}
				stack.push(res);
			}
		}
		
		String ans = String.format("%.2f", stack.pop());
		System.out.println(ans);
	}

}
