package ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



//  테스트 케이스
//	CBBCBAAB
//	CCCBABCB
//	CAAAACAB
//	BACCCCAC
//	AABCBBAC
//	ACAACABC
//	BCCBAABC
//	ABBBCCAA

// 회문1_임영묵 코드에서
public class swea1215_ttt {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[8][8];
		for(int i=0; i<8; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		// 1번
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(arr[1]);					// 왜 주소값이 안찍히지...? 4번
		
		
		// 2번
		char[] cc = arr[0];
		System.out.println(Arrays.toString(cc));
		System.out.println(cc);
		
		
		// 3번_ character 배열을 String로 바꿔줌
		String str = new String(arr[0]);
		System.out.println(str);
		
		
		// 4번_ int형 char형
		int[] array = {1,2,3,4,5,6};
		System.out.println(array);
		
		char[] array2 = {'a','b','c','d','e','f'};
		System.out.println(array2);
		
		
	} // main

}
