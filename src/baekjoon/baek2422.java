package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2422 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[m][2];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		String str;
		boolean flag = true;
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				for(int k=j+1; k<=n; k++) {
					str = i+""+j+""+k;
					for(int p=0; p<m; p++) {
						if(str.contains(arr[p][0]+"") && str.contains(arr[p][1]+"")) {
							flag = false;
						}
					}
					
					if(flag) {
						cnt++;
					}
					
					flag=true;
				}
			}
		}
		
		System.out.println(cnt);
        br.close();
		
	} //main

}
