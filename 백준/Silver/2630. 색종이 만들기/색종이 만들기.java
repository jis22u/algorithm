import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    static int N, wcnt, bcnt;
    static int[][] paper;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        wcnt = bcnt = 0;
        visited = new boolean[N][N];

        search(N);
        System.out.println(wcnt+"\n"+bcnt);
    } // main

    static void search(int len) {
        if(len < 1) return;

        // 움직일 좌표값
        List<Integer> dlist = new ArrayList<>();
        List<Integer> klist = new ArrayList<>();
        for(int i=0; i<N; i+=len) {
            dlist.add(i);
            klist.add(i);
        }

        // 한변의 길이만큼 탐색
        int s = dlist.size();
        for(int d=0; d<s; d++) {
            int nr = dlist.get(d);
            for(int k=0; k<s; k++) {
                int nc = klist.get(k);

                // 0 or 1로 같은지 다른지 탐색
                int v = -1;
                boolean flag = true;
                boolean Tflag = true;
                for(int i=nr; i<nr+len; i++) {
                    for(int j=nc; j<nc+len; j++) {
                        if(visited[i][j]) { Tflag=false; break; }
                        if(flag) { flag = false; v = paper[i][j]; }
                        if(v != paper[i][j]) { Tflag=false; break; }
                    }
                }

                // 방문한 곳 T 처리, 개수세기
                if(Tflag) {
                    for(int i=nr; i<nr+len; i++) {
                        for(int j=nc; j<nc+len; j++) {
                            visited[i][j] = true;
                        }
                    }
                    if(v==0) {wcnt++;}
                    else {bcnt++;}
                }
            }
        }

        // 더 탐색
        search(len/2);
        
    } // search
}