import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int cnt = 0;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        List<Integer> list = new ArrayList<>();
        int[][] map = new int[n+1][n+1];
        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(!visited[c] && r == 1) {
                list.add(c);
                cnt++;
                visited[c] = true;
            } else if(!visited[r] && c == 1) {
                list.add(r);
                cnt++;
                visited[r] = true;
            }
            map[r][c] = map[c][r] = 1;
        }

        
        int size = list.size();
        for(int i=0; i<size; i++) {
            int r = list.get(i);
            for(int c=1; c<n+1;c++) {
                if(map[r][c] == 1 && !visited[c]) {
                    visited[c] = true;
                    cnt++;
                }
            }
        }
      
        System.out.println(cnt);
        
    }
}