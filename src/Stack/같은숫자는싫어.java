package Stack;

import java.util.*;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		
		int[] arr = {1,1,3,3,0,1,1};
		
		Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i=1; i<arr.length; i++) {
            if(stack.peek() == arr[i]) continue;
            stack.push(arr[i]);
        }

        int size = stack.size();
        int[] answer = new int[size];

        for(int i=size-1; i>=0; i--) {
            answer[i] = stack.pop();
        }
        
        for(int a:answer) {
        	System.out.print(a + " ");
        }
		
	}

}
