import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 11055
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dpSum = new int[n];
		dpSum[0] = arr[0];
		for(int i=1; i<n; i++) {
			dpSum[i] = arr[i];
			int tmp = 0;
			for(int j=0; j<i; j++) {
				if(arr[j]< arr[i]) {
					dpSum[i] = arr[i]+Math.max(dpSum[j], tmp);
					tmp = Math.max(dpSum[j], tmp);
				}
			}
		}
		
//		System.out.println(Arrays.toString(dpSum));
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, dpSum[i]);
		}
		System.out.println(max);
		
	} // main

}
