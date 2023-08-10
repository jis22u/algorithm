package 그리디;

import java.util.*;
import java.io.*;


public class 스마트물류
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] line = br.readLine().toCharArray();
        boolean[] visited = new boolean[N];
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(line[i] == 'P') {    // 로봇이면
                for(int j=i-K; j<=i+K; j++) {
                    if(j == i) continue;
                    if(j<0 || j>=N) continue;
                    if(!visited[j] && line[j] == 'H') {
                        visited[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
