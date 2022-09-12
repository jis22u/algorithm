package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1969 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] ans = new int[m][4];  				 // 0:A 1:C 2:G 3:T
		
		String[] dna = new String[n];
		for(int i=0; i<n; i++) {
			dna[i] = br.readLine();
		}
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				if(dna[i].charAt(j) == 'A') {
					ans[j][0]++;
				} else if (dna[i].charAt(j) == 'C') {
					ans[j][1]++;
				} else if (dna[i].charAt(j) == 'G') {
					ans[j][2]++;
				} else {
					ans[j][3]++;
				}
			}
		}
		
		int max=0;
		int sum=0;
		String str = "";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			max=0;
			int jj = 0;
			for(int j=0; j<4; j++) {
				if(ans[i][j] > max) {
					max = ans[i][j];
					jj = j;
					if(j == 0) {
						str = "A";
					} else if(j == 1) {
						str = "C";
					} else if(j == 2) {
						str = "G";
					} else if(j == 3) {
						str = "T";
					}
				}
			}
			sb.append(str);
			
			for(int j=0; j<4; j++) {
				if( j!=jj && ans[i][j] <= max) {
					sum += ans[i][j];
				}
			}
		}
		
		
		System.out.println(sb+"\n"+sum);
		br.close();
	}

}
