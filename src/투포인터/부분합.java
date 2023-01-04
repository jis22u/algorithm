package 투포인터;

import java.io.*;
import java.util.*;


// 한 자리 수열 고려하기
// 근데 시간초과 신발 갖다버려야지
public class 부분합 {

	public static void main(String[] args) throws IOException {
		/**
		 * 일단 N이 100000개이므로 완탐은 안되겠다. 시간초과
		 * 투포인터로?? 
		 * 수열이여서 정렬하면 안되는데....
		 * 정렬 안하는 대신 st, ed 설정해놓고 ed만 움직이면 되나?
		 */
		
		// N번 반복
		// st부터 ed까지 더한다.
		// 그 합이 S보다 작으면 ed++
		// 				 크거나 같으면 다음 n번째 원소 검사
		// 				 	  		   ed-st+1개 저장
		// min값 계산해주기!!
		
		// 한 자리 수열 고려**
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		// N: 수열의 길이, S: 타겟 값
		int N = Integer.parseInt(stz.nextToken());
		int S = Integer.parseInt(stz.nextToken());
		
		// N개 수열
		stz = new StringTokenizer(br.readLine()); 
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		
		int len = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int st = i;
			int ed = i;
			
			
			int sum = arr[st];
			while(ed<N) {
				
				if(sum >= S) {
					len = ed-st+1; break;
				} else {
					ed++;
					
					if(ed == N && sum >= S) { len=1; break;}
					else if(ed == N) { break; }
					
					sum += arr[ed];
				}
			}
			min = Math.min(min, len);
		}
		
		System.out.println(min);
	} // main

}
