package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static class Tomato {
        int h,r,c,day;
        Tomato (int h, int r, int c, int day) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());    // 상자의 가로 칸 수
        int N = Integer.parseInt(st.nextToken());    // 상자의 세로 칸 수
        int H = Integer.parseInt(st.nextToken());    // 상자의 개수 (높이)

        int[][][] tomatos = new int[H][N][M];        // 토마토 상자
        Queue<Tomato> q = new LinkedList<>();        // 익은 토마토 저장
        boolean ripe = false;
        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++) {
                    tomatos[h][n][m] = Integer.parseInt(st.nextToken());
                    if(tomatos[h][n][m] == 0) { ripe= true; }
                    if(tomatos[h][n][m] == 1) { q.add(new Tomato(h, n, m, 0)); }
                }
            }
        }

        int[] dh = {0,0,0,0,1,-1};         // 오른쪽 왼쪽 위 아래 앞 뒤
        int[] dr = {0,0,1,-1,0,0};
        int[] dc = {1,-1,0,0,0,0};

        int ans = 0;
        while(!q.isEmpty()) {
            Tomato t = q.poll();
            ans = t.day;

            for(int i=0; i<6; i++) {
                int nh = t.h + dh[i];
                int nr = t.r + dr[i];
                int nc = t.c + dc[i];

                if(nh>=H || nr>=N || nc>=M || nh<0 || nr<0 || nc<0) continue;
                if(tomatos[nh][nr][nc] == 1 || tomatos[nh][nr][nc] == -1) continue;

                tomatos[nh][nr][nc] = 1;
                q.add(new Tomato(nh, nr, nc, t.day+1));
            }
        }

        if(!ripe) { System.out.println(0); }     // 저장할 때부터 익었음
        else {
            // 처음부터 0인 토마토 개수 세서 익었으면 cnt-- 
            // 남은 cnt 개수 파악하면 다 익었는지 못 익었는지 알 수 있음
            for(int h=0; h<H; h++) {
                for(int n=0; n<N; n++) {
                    for(int m=0; m<M; m++) {
                        if(tomatos[h][n][m] == 0) {
                            ans = -1;
                            break;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
