package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상근이의여행 {

    static int[][] map;
    static int cnt, N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        /**
         * 최대한 적은 종류의 비행기
         * 다른 국가 거쳐 가도 되고, 이미 방문한 국가라도 괜찮
         * 왕복하는 비행기 > 무향 그래프..?
         * 정답: 가장 적은 종류의 비행기, 모든 국가 여행
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            // 0. 입력받기
            StringTokenizer stz = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stz.nextToken());
            int M = Integer.parseInt(stz.nextToken());

            // 1. 그래프 연결상태를 표현해야하고, 인접행렬
            map = new int[N+1][N+1];
            for(int m=0; m<M; m++) {
                stz = new StringTokenizer(br.readLine());
                int st = Integer.parseInt(stz.nextToken());
                int ed = Integer.parseInt(stz.nextToken());
                map[st][ed] = 1;
                map[ed][st] = 1;
            }

            // 2. 탐색
            cnt = 0;
            visited = new boolean[N+1];
            dfs(1);
            System.out.println(cnt-1);  // 비행기는 정점이 아닌 간선이므로
            System.out.println(N-1);
        }
    }

    static void dfs(int v) {
        visited[v] = true;
        cnt++;  // dfs 함수가 호출될 때마다 비행기의 종류 수를 증가

        for(int i=1; i<N+1; i++) {
            if(map[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
