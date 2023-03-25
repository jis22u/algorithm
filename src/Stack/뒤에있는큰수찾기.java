package Stack;

import java.util.Stack;

public class 뒤에있는큰수찾기 {

	public static void main(String[] args) {
		int[] numbers = {2,3,3,5};
		
		// 처리된 정수는 스택에 담을거야
		Stack<Integer> stack = new Stack<>();
		// 정답 담을 배열
		int[] answer = new int[numbers.length];

		for(int i=numbers.length-1; i>=0; i--) {
		    while(!stack.isEmpty()) {
			// peek이랑 비교
			int target = stack.peek();
			// peek이 더 크다면 뒷큰수
			if(numbers[i] < target) {
			    answer[i] = target;
			    break;
			} 
			// 해당 정수가 더 크다면 스택에 있는거 pop 해버리기
			else {
			    stack.pop();
			}
		    }
		    // 스택에 쌓인거 다 꺼내봐도 없다면 뒷큰수가 없는 것
		    if(stack.isEmpty()) {
			answer[i] = -1;
		    }
		    stack.push(numbers[i]);
		}

		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]);
		}
	}

}
