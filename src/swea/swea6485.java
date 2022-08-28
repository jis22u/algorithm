package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 풀어보자..
// 일일이 배열 생성하지 않고도 다른 작업이랑 동시에 처리할 수 있는 방법!!


// 삼성시의 버스 노선
public class swea6485 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());

			int[] pass = new int[5001];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				for(int k = A; k<=B; k++) {
					pass[k]++;
				}
			}

			int p = Integer.parseInt(br.readLine());
			int[] station = new int[p];
			for(int i=0; i<p; i++) {
				station[i] = pass[Integer.parseInt(br.readLine())];
			}
		
			
			sb = new StringBuilder();
			sb.append("#"+t+" ");
			for(int i=0; i<p; i++) {
				sb.append(station[i]+" ");
			}
			sb.delete(sb.length()-1, sb.length());
		
			System.out.println(sb);
		}
		
		br.close();
		
	} //main

}
