package Stack;

import java.util.Stack;

public class 짝지어제거하기 {

	public static void main(String[] args) {
		String s = "baabaa";
		
		 // 문자열 저장
        char[] arr = s.toCharArray();
        // 처리 중인 문자들 저장
        Stack<Character> stack = new Stack<>();
       
        char cur_word = '0';
        char past_word = '0';
        for(int i=0; i<s.length(); i++) {
            cur_word = arr[i];
            // 처리할 문자가 있다면
            if (!stack.isEmpty()) {
                // stack 맨 위에 있는 원소가 무엇인지 보기
                past_word = stack.peek();
                // stack 맨 위에 문자와 동일하다면
                if(cur_word == past_word) {
                    // 해당 문자 제거
                    stack.pop();                
                } else {
                    // 아니면 현재 문자 stack에 이어서 쌓아놓기
                    stack.push(cur_word);
                }
            // 처리할 문자가 없다면
            } else {
                // 현재 문자 일단 stack에 저장
                stack.push(cur_word);
            }
        }
        
        int answer = -1;
        if(!stack.isEmpty()) {
            answer = 0;
        } else {
            answer = 1;
        }
        
        System.out.println(answer);
	}

}
