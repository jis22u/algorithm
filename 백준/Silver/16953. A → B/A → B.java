import java.util.*;
import java.io.*;

class Main {

    static class Node {
        long v;
        int cnt;
        Node(long v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A,0));

        int ans = -1;
        while(!q.isEmpty()) {
            Node n = q.poll();

            if(n.v == B) {
                ans = n.cnt + 1;
                break;
            }
            
            // 곱하기 2
            if(n.v*2 <= B) {
                q.add(new Node(n.v*2, n.cnt+1));
            }
            
            // 오른쪽에 1추가
            StringBuilder sb = new StringBuilder(n.v+"");
            String tStr = sb.append(1).toString();
            long tNum = Long.parseLong(tStr);
            if(tNum <= B) {
                q.add(new Node(tNum, n.cnt+1));
            }
        }
        
        System.out.println(ans);
            
    } // main
}