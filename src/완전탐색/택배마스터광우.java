package 완전탐색;

import java.util.*;
import java.io.*;


public class 택배마스터광우
{
    static int N, M, K, ans;
    static int[] rails, order;
    static boolean[] visited;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rails = new int[N];
        order = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            rails[i] = Integer.parseInt(st.nextToken());
        }

        ans = Integer.MAX_VALUE;
        serach(0);
        System.out.println(ans);
    }

    static void serach(int idx) {
        if(idx == N) {
            ans = Math.min(ans, weight(order));
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            order[idx] = rails[i];
            serach(idx+1);
            visited[i] = false;
        }
    }

    static int weight(int[] arrOrder) {
        int i = 0;
        int j = 0;
        int one = 0;
        int sum = 0;
        while(i<K) {
            while(one + arrOrder[j%N]<=M) {
                one += arrOrder[j++%N];
            }
            sum += one;
            one = 0;
            i++;
        }
        return sum;
    }
}