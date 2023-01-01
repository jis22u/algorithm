package 완전탐색;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution({1,2,3,4,5});
	}

}

	static  int[] solution(int[] answers) {
        // 문제 길이
        int len = answers.length;
        // 수포자 원투쓰리가 맞힌 문제 개수 저장
        int[] answer = new int[3];
        // 수포자 3인방
        int[][] arr = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
       
        // 맞히 문제 개수 세기
        int cnt = 0;
        for(int i=0; i<3; i++) {
            // n번째 수포자 배열 길이
            int s = arr[i][].length;
            for(int j=0; j<len; j++) {
                if(answers[j] == arr[i][j%s]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
        
      
        return answer;
    }
}
