package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 과일서리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][M+1];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= M; j++) {
                int sum = 0;
                for (int k = 1; k <= j-1; k++) {
                    sum += dp[i-1][k];
                }
                dp[i][j] = sum;
            }
        }
        System.out.println(dp[N][M]);
    }
}

//  M이 동일할 때 N이 1개 증가한 상황은 어떤 걸까요?
//  N=3에서 N=4가 됐다는 건 A,B,C 과일을 훔치던 상황에서 A,B,C,D 과일을 훔쳐야 되는 상황으로 변경된 겁니다.
//  이때 M의 개수가 동일하기 때문에 새롭게 추가된 D의 개수를 기준으로 생각해보면 됩니다.
//      만약 D를 1개 훔쳤다면 우리는 A,B,C를 총 M-1개 훔쳐야 합니다.
//      만약 D를 2개 훔쳤다면 우리는 A,B,C를 총 M-2개 훔쳐야 합니다.
//      만약 D를 x개 훔쳤다면 우리는 A,B,C를 총 M-x개 훔쳐야 합니다.