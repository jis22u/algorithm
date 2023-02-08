package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		// 소요 기간 저장할 큐
        Queue<Integer> queue = new LinkedList<>();
        // 소요 기간 구하고
        int len = progresses.length;
        for(int i=0; i<len; i++) {
            int needs = 100 - progresses[i];
            int days = needs%speeds[i];
            if(days == 0) {
                queue.add(needs/speeds[i]);
            } else {
                queue.add(needs/speeds[i] + 1);
            }
        }

        // 배포일 마다 개수 구할거야
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        while(!queue.isEmpty()) {
            int A = queue.poll();

            out:
            while(true) {
                if(queue.peek() == null) {
                    list.add(cnt);
                    break out;
                }

                int B = queue.peek();

                if(A>=B) {
                    cnt++;
                    queue.poll();
                }
                if(A<B) {
                    list.add(cnt);
                    break out;
                }
            }
            cnt = 1;
        }

        int size = list.size();

        int[] answer = new int[size];
        for(int i=0; i<size; i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }
        

        
	}

}
