package 정렬;

import java.util.Arrays;

public class K번째수 {

	public static void main(String[] args) {

		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		// 반복해야 하는 횟수 구하기
        int len = commands.length;
        
        // 정답 담을 곳
        int[] answer = new int[len];
        
        // 아래의 과정을 len번 반복할 것이다.
        for(int d=0; d<len; d++) {
            int i = commands[d][0];
            int j = commands[d][1];
            int k = commands[d][2];
            
            // 잘라서 가져올 배열의 크기
            int size = j-i+1;
            int[] arr = new int[size];
            
            // i부터 j까지 가져오기
            for(int p=0; p<size; p++) {
                arr[p] = array[p+i-1];
            }
            
            // 정렬
            Arrays.sort(arr);
            
            // k번째 숫자 저장
            answer[d] = arr[k-1];
        }

        for(int a : answer) {
        	System.out.print(a+" ");
        }
	}

}
