package 구현;

import java.util.*;
import java.io.*;

public class GBC
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] flag = new int[2][N];   // 0번째 줄: 구간, 1번째 줄: 속도도
        int[][] gw = new int[2][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            flag[0][i] = Integer.parseInt(st.nextToken());
            flag[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            gw[0][i] = Integer.parseInt(st.nextToken());
            gw[1][i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        int r = 0;
        int c = 0;
        int val = 0;
        while(r<N) {
            while(c<M) {
                val = (gw[1][c] - flag[1][r] < 0)? 0: gw[1][c] - flag[1][r];
                list.add(val);
                if(flag[0][r] < gw[0][c]) {
                    gw[0][c] = gw[0][c] - flag[0][r];
                    r++;
                } else if(flag[0][r] > gw[0][c]){
                    flag[0][r] = flag[0][r] - gw[0][c];
                    c++;
                } else {
                    r++;
                    c++;
                }
                break;
            }
        }

        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }
}
