package 구현;

import java.util.*;

public class 과제진행하기 {

	public static void main(String[] args) {
		String[][] plans = {{"science", "12:40", "50"},{"music", "12:20", "40"},{"history", "14:00", "30"},{"computer", "12:30", "100"}};
		
		
		// 각 작업을 시작 시간 순서대로 우선순위 큐에 저장
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<plans.length; i++) {
            pq.add(new Node(plans[i][0],plans[i][1],plans[i][2]));
        }
        
        // 미완료작업 - 스택
        Stack<Task> stack = new Stack<>();
        // 완료작업 - 큐
        Queue<String> q = new LinkedList<>();
        // 해당 노드
        Node cur = null;
        // 다음 순번 노드
        Node next = null;
        // 작업 가능한 시간
        int taskTime = 0; 
        // pq가 빌 때까지 반복
        while(!pq.isEmpty()) {
            cur = pq.poll();
            next = pq.peek();
            // 마지막 노드라면 완료 큐에 저장하고 끝내기
            if(next == null) {
                q.add(cur.name);
                break;
            }
            // 작업 가능 시간 구하기
            taskTime = doTaskTime(cur.hh, cur.mm, next.hh, next.mm);
            
            if(taskTime == cur.playtime) {
                q.add(cur.name);
            } else if (taskTime > cur.playtime) {  // 시간이 남는 경우
                q.add(cur.name);
                
                int rest = taskTime - cur.playtime;
                while(true) {
                    Task t = stack.pop();
                    if(rest - t.playtime > 0) {
                        q.add(t.name);
                    } else if (rest - t.playtime < 0) {
                        stack.push(new Task(t.name, t.playtime-rest));
                        break;
                    } else {
                        q.add(t.name);
                    }
                }
            } else {                               // 시간이 모자란 경우
                stack.push(new Task(cur.name, cur.playtime-taskTime));
            }
        
        }
        int qSize = q.size();
        int stackSize = stack.size();
        
        String[] answer = new String[qSize + stackSize];
        for(int i=0; i<qSize; i++) {
            answer[i] = q.poll();
        }
        
        for(int i=qSize; i<qSize+stackSize; i++) {
            answer[i] = stack.pop().name; 
        }
        
        for(int i=0; i<answer.length; i++) {
        	System.out.print(answer[i]+" ");
        }
	}
	
	// 작업 가능 시간 구하기
    static int doTaskTime(int curHH, int curMM, int nextHH, int nextMM){
        int hour = 0;
        if(nextHH == curHH) {
            return nextMM - curMM;
        } else {
            hour = nextHH - curHH;
            if(curHH == nextMM) {
                return hour * 60;
            } else if (nextMM > curMM) {
                return (nextMM - curMM) + (hour*60);
            } else {
                return (60-curMM) + nextMM + (hour-1)*60;
            }
        }
    }
	
	// 미완료작업을 Task 클래스로 관리
    static class Task {
        String name;
        int playtime;
        
        Task(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
    }
	
	// 각 작업을 Node 클래스로 관리
	 static class Node implements Comparable<Node> {
	        String name;
	        String start;
	        int playtime;
	        int hh;
	        int mm;
	        
	        Node(String name, String start, String playtime) {
	            this.name = name;
	            this.start = start;
	            this.playtime = Integer.parseInt(playtime);
	            this.hh = Integer.parseInt(start.substring(0,2));
	            this.mm = Integer.parseInt(start.substring(3));
	        }
	        
	        @Override
	        public int compareTo(Node o) {
	            int HH = Integer.compare(this.hh, o.hh);
	            if(HH != 0) {
	                return HH; 
	            }
	            return Integer.compare(this.mm, o.mm);
	        }
	    }

}
