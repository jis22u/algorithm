import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] dp = new int[n+5];
		Arrays.fill(dp,-1);
		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;
		
		for(int i=6; i<=n; i++) {
			if(dp[i-2]==-1 && dp[i-5]==-1) {
				dp[i] = -1;
				continue;
			}
			
			int min=0;
			if(dp[i-2]==-1) {
				min = dp[i-5];
			} else if(dp[i-5]==-1) {
				min = dp[i-2];
			} else {
				min = Math.min(dp[i-2], dp[i-5]);
			}
			dp[i]= min+1;
		}
		
		System.out.println(dp[n]);
	
	}

}
