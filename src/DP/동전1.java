package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];
        for(int i = 1; i<=n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                if(j-coins[i]>=0) {
                    dp[i][j]  = dp[i][j-coins[i]] + dp[i-1][j];
                } else {
                    dp[i][j]  = dp[i-1][j];
                }
            }
        }

//        for(int i=1; i<=n; i++) {
//            for(int j=1; j<=k; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][k]);
    }
}