package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {

	public static void main(String[] args) throws IOException {
		// 입력받기 N: 수의 개수, arr: N개의 숫자들
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(arr);
		
		// 정답
		int ans = 0;
		
		// 왼+오 원소랑 해당 원소 같은거 찾아라 
		for(int i=0; i<N; i++) {
			int left = 0;
			int right = N-1;
			
			while(left < right) {    
				if(i==left) left += 1;
				else if(i==right) right -= 1;
				
				if(left == right) break;
				
				int key = arr[left] + arr[right];
				
				if(key > arr[i]) { right -= 1; }
				else if(key < arr[i]) { left += 1; }
				else { ans++; break;}
			}
		}
		
		System.out.println(ans);
	} // main

}
