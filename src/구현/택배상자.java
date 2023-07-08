package 구현;

import java.util.*;

public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {4,3,1,2,5};

        int boxCnt = order.length;
        int start = order[0];

        // 큐: start부터 boxCnt까지 큐에 담기
        Queue<Integer> queue = new LinkedList<>();
            for(int i=start; i<=boxCnt; i++) {
            queue.add(i);
        }
        // 스택: 1부터 start-1까지 스택에 담기
        Stack<Integer> stack = new Stack<>();
            for(int i=1; i<start; i++) {
            stack.push(i);
        }

        // 컨테이너 벨트에 실어보자
        int answer = 0;
        for(int i=0; i<boxCnt; i++) {
            if(!stack.isEmpty() && order[i] == stack.peek()) {
                stack.pop();
                answer++;
            } else if(!queue.isEmpty() && order[i] == queue.peek()) {
                queue.poll();
                answer++;
            } else if (queue.contains(order[i])) {
                while(true) {
                    int target = queue.peek();
                    if(target == order[i]) { queue.poll(); answer++; break; }
                    stack.push(queue.poll());
                }
            } else {
                break;
            }
        }
        System.out.println(answer);
    }
}
