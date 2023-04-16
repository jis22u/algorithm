package 구현;

import java.util.Arrays;

public class 최댓값과최솟값 {

	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		// 문자열을 배열로 받아주기
		String[] c = s.split(" ");
		int[] num = new int[c.length];
		// 문자열을 정수형 숫자로 변환
		for(int i=0; i<c.length; i++) {
		    num[i] = Integer.parseInt(c[i]);
		}
		// 정렬
		Arrays.sort(num);
		// 정답 출력
		String answer = num[0]+" "+num[num.length-1];
		System.out.println(answer);
		
	}

}
