package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 장애물인식프로그램 {

    static int N, cnt;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        ArrayList<Integer> blocks = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1) {
                    cnt = 1;
                    map[i][j] = 0;
                    dfs(i, j);
                    blocks.add(cnt);
                }
            }
        }
        Collections.sort(blocks);
        System.out.println(blocks.size());
        for(int b:blocks) {
            System.out.println(b);
        }
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static void dfs(int i, int j) {
        for(int d=0; d<4; d++) {
            if(i+dr[d]<0 || j+dc[d]<0 || i+dr[d]>=N || j+dc[d]>=N) continue;
            if(map[i+dr[d]][j+dc[d]] == 0) continue;
            map[i+dr[d]][j+dc[d]] = 0;
            cnt++;
            dfs(i+dr[d], j+dc[d]);
        }
    }
}
