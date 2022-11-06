
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int n = sc.nextInt();
			dp = new int[n+3];
			Arrays.fill(dp, -1);
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			System.out.println(dynamic(n));
			
		}
	} // main

	static int[] dp;
	static int dynamic(int n) {
		if(dp[n] == -1) {
			for(int i=4; i<=n; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
		}
		return dp[n];
	}
}
