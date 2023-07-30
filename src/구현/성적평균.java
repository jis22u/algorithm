package 구현;

import java.util.*;
import java.io.*;


public class 성적평균
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int K = Integer.parseInt(stz.nextToken());

        int[] scores = new int[N];
        stz = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(stz.nextToken());
        }

        int st, ed = 0;
        double sum = 0.0;
        String ans = "";

        for(int i=0; i<K; i++) {
            stz = new StringTokenizer(br.readLine());
            st = Integer.parseInt(stz.nextToken());
            ed = Integer.parseInt(stz.nextToken());

            sum = 0.0;
            for(int j=st-1; j<=ed-1; j++) {
                sum += scores[j];
            }
            ans = String.format("%.2f" ,sum/(ed-st+1));
            System.out.println(ans);
        }
    }
}
