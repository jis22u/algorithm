package 완전탐색;

import java.util.*;

public class 모의고사프로그램{
	public static void main(String[] args) { 
		int[] answers = {1,3,2,4,2};
		for(int a : solution(answers)) {
			System.out.print(a);
		}
	}

static int[] solution(int[] answers) {
        // 문제 길이
        int len = answers.length;
        // 수포자 3인방
        int[][] arr = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
       
        // 맞힌 문제 개수 세기 & 최대값 찾기
        int[] how = new int[3];
        int cnt = 0;
        int max = 0;
        for(int i=0; i<3; i++) {
            // n번째 수포자 배열 길이
            int s = arr[i].length;
            for(int j=0; j<len; j++) {
                if(answers[j] == arr[i][j%s]) {
                    cnt++;
                }
            }
            how[i] = cnt;
            max = Math.max(cnt, max);
            cnt = 0;
        }
        
        // 정답 많이 맞힌 사람
        ArrayList<Integer> list = new ArrayList<>();
        // 누구?
        for(int i=0; i<3; i++) {
            // 최대값만큼 문제 맞힌 사람 찾아
            if(how[i] == max) {
              list.add(i+1);
            }
        }
        
        // 리스트에 담긴거 배열로 옮겨줘
        int siz = list.size();
        int[] answer = new int[siz];
        for(int i=0; i<siz; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

}
