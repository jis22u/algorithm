package BFS;

import java.util.LinkedList;
import java.util.Queue;


public class 네트워크 {
	
    public static void main(String[] args) {
        int n = 4;
        int[][] computers = {{1,1,0,1}, {1,1,0,0}, {0,0,1,1}, {1,0,1,1}};

	    // 네트워크 한 묶음 저장소
	    Queue<Node> q = new LinkedList<>();
	
	    // 4방 탐색
	    int[] dr = {0,1,0,-1};
	    int[] dc = {1,0,-1,0};
	
	    // 네트워크 개수
	    int cnt = 0;
	
	    // 연결 상태를 다 돌아다니면서 체크할거야
	    for(int i=0; i<n; i++) {
	        for(int j=0; j<n; j++) {
	            // 연결이 되어있으면
	            if(computers[i][j] == 1) {
	                // 일단 네크워크 하나 세어주고, 주변 연결상태 체크
	                cnt++;
	                System.out.println(">>>>> "+i+" "+j);
	
	                q.add(new Node(i,j));
	                computers[i][j] = 0;
	
	                while(!q.isEmpty()) {
	                    Node node = q.poll();
	                    // 꺼낸 노드 중심으로 4방 탐색해봐
	                    for(int d=0; d<4; d++) {
	                        int nr = node.i + dr[d];
	                        int nc = node.j + dc[d];
	
	                        if(nr<0 || nc<0 || nr>=n || nc >=n) continue;
	                        if(computers[nr][nc] == 0) continue;
	
	                        // 연결되어있으면
	                        // 방문체크 0처리, 큐에 담아줘
	                        System.out.println(nr+" "+nc);
	                        computers[nr][nc] = 0;
	                        q.add(new Node(nr,nc));
	                    }
	                }
	
	            }
	        }
	    }
	
	
	    int answer = cnt;
	    System.out.println(cnt);

    }

	static class Node {
	    int i,j;
	
	    public Node(int i, int j) {
	        this.i = i;
	        this.j = j;
	    }
	}
}
