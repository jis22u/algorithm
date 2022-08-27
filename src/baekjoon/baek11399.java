package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek11399 {
   
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] sum= new int[n];
		int tmp=0;
		for(int i=0; i<n; i++) {
			tmp += arr[i];
			sum[i] = tmp;
		}
		
		int ans=0;
		for(int i=0; i<n; i++) {
			ans += sum[i];
		}
		
		System.out.println(ans);
		br.close();
	}

}

// sum[] 배열을 만들지 않고도 가능하다
//		Arrays.sort(arr);
//		//누적합 시켜주기
//		for(int i=1;i<n;i++) {
//			arr[i]+=arr[i-1];
//		}
//		//누적합 한것을 또 누적합하기.
//		for(int i=1;i<n;i++) {
//			arr[i]+=arr[i-1];
//		}
//		//출력
//		bw.write(arr[n-1]+"\n");
//		bw.flush();
//		bw.close();
