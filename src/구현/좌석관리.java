package 구현;

import java.util.*;
import java.io.*;


public class 좌석관리
{
    static int N,M;
    static boolean[][] seatStatus;
    static int[][] getSeat;
    static boolean[] in, out;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Queue<String> q = new LinkedList<>();
        for(int i=0; i<Q; i++) {
            q.add(br.readLine());
        }
        // 사람 수
        int p = q.size();
        // 좌석 현황표
        seatStatus = new boolean[N+1][M+1];
        // 사람별 얻은 좌석 (x,y) > [][0]:x, [][1]:y
        getSeat = new int[p+1][2];
        // 사람별 In 현황
        in = new boolean[p+1];
        // 사람별 Out 현황
        out = new boolean[p+1];



        while(!q.isEmpty()) {
            st = new StringTokenizer(q.poll());
            String what = st.nextToken();
            int who = Integer.parseInt(st.nextToken());

            if(what.equals("Out")) {
                if(!in[who]) {
                    System.out.printf("%d didn't eat lunch.\n", who);
                } else if(in[who] && out[who]) {
                    System.out.printf("%d already left seat.\n", who);
                } else if(in[who] && !out[who]) {
                    System.out.printf("%d leaves from the seat (%d, %d).\n", who, getSeat[who][0], getSeat[who][1]);
                    seatStatus[getSeat[who][0]][getSeat[who][1]] = false;
                    out[who] = true;
                }
            } else {
                if(in[who] && out[who]) {
                    System.out.printf("%d already ate lunch.\n", who);
                } else if(in[who] && !out[who]) {
                    System.out.printf("%d already seated.\n", who);
                } else if(!in[who]) {
                    // 탐색 ㄱㄱㄱ
                    searchSeat(who);
                }
            }
        }

    }

    static void searchSeat(int who) {
        // 일단 안전 지표를 구해보자
        int[][] safe = new int[N+1][M+1];   // 안전도 지표
        for(int i=1; i<=N; i++) {
            Arrays.fill(safe[i], Integer.MAX_VALUE);
        }
        boolean empty = true;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(seatStatus[i][j]) {
                    empty = false;
                    for(int r=1; r<=N; r++) {
                        for(int c=1; c<=M; c++) {
                            if(i==r && j==c) continue;
                            int v = (i-r)*(i-r) + (j-c)*(j-c);
                            safe[r][c] = Math.min(safe[r][c], v);
                        }
                    }
                }
            }
        }


        if(empty) {
            getSeat[who][0] = 1;
            getSeat[who][1] = 1;
            in[who] = true;
            seatStatus[1][1] = true;
            System.out.printf("%d gets the seat (1, 1).\n", who);
            return;
        }

        // 안전도 가장 높은 좌석을 찾아보자
        int max = Integer.MIN_VALUE;
        List<int[]> maxSafe = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(seatStatus[i][j]) continue;
                if(safe[i][j] > max) {
                    max = safe[i][j];
                }
            }
        }

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,-1,1};
        outter:
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(seatStatus[i][j]) continue;
                if(safe[i][j] == max) {
                    boolean flag = true;
                    for(int d=0; d<4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(nr<1 || nr>=N+1 || nc<1 || nc>=M+1) continue;
                        if(seatStatus[nr][nc]) flag = false;
                    }
                    if(flag) {
                        getSeat[who][0] = i;
                        getSeat[who][1] = j;
                        in[who] = true;
                        seatStatus[i][j] = true;
                        System.out.printf("%d gets the seat (%d, %d).\n", who, i, j);
                        break outter;
                    }
                }
            }
        }

        if(getSeat[who][0] == 0 && getSeat[who][1] == 0){
            System.out.println("There are no more seats.");
        }
    }
}
