package Stack;

import java.util.Stack;

public class 햄버거만들기 {

	public static void main(String[] args) {
		int[] ingredient = {2,1,1,2,3,1,2,3,1};
		
		Stack<Integer> stack = new Stack<>();
        
        int answer = 0;
        for(int in : ingredient) {
            stack.add(in);
            
            if(stack.size() >= 4) {
                
                if(stack.get(stack.size()-4) == 1 && stack.get(stack.size()-3) == 2 
                  && stack.get(stack.size()-2) == 3 && stack.get(stack.size()-1) == 1) {
                    for(int i=0; i<4; i++) {
                        stack.pop();
                    }
                    answer++;
                }
            }
        }
        
        System.out.println(answer); 

	}

}
