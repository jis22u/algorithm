package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len2+1][len1+1];

        for(int i=1 ; i<=len1; i++) {
            for(int j=1; j<=len2; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[j][i] = Math.max(dp[j-1][i-1]+1, dp[j-1][i]);
                } else {
                    dp[j][i] = Math.max(dp[j][i-1], dp[j-1][i]);
                }
            }
        }
        System.out.println(dp[len2][len1]);
    }
}
