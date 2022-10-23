
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] dp = new int[n+5];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;
		
		for(int i=6; i<=n; i++) {
			dp[i]= Math.min(dp[i-2], dp[i-5])+1;
		}
		int ans = 0;
		if(dp[n] == Integer.MAX_VALUE) {
			ans = -1;
		} else {
			ans = dp[n];
		}
		System.out.println(ans);
	
	}

}