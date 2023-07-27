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
        int k = 0;
        for(int i=0; i<N; i++) {
            for(int j=k; j<M; j++) {
                if(flag[0][i] < gw[0][j]) {
                    list.add(gw[1][j] - flag[1][i]);
                    gw[0][j] = gw[0][j] - flag[0][i];
                    k = j;
                } else {
                    list.add(gw[1][j] - flag[1][i]);
                    k = j+1;
                }
                break;
            }
        }

        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }
}
