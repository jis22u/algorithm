package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int value = Math.min(N,M);

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        outter:
        for(int v=value; v>=1; v--) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(j + v - 1>=M || i+v-1>=N) continue;
                    if (map[i][j] == map[i][j + v - 1] && map[i][j] == map[i+v-1][j+v-1] && map[i][j] == map[i+v-1][j]) {
                        System.out.println(v*v);
                        break outter;
                    }
                }
            }
        }
    }
}
