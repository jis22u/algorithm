package DFS;

// 프로그래머스 실패--------
// 괄호가 들어갈 자리를 찾는게 아니다....
import java.util.Arrays;

public class 타겟넘버 {

	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		solution(numbers, 3);
	}
	
	static char[] cal;
	static int len;
	static int solution(int[] numbers, int target) {
	        // 연산할 숫자의 개수
	        len = numbers.length;
	        // 필요한 괄호의 개수
	        cal = new char[len-1];
	        
	        // len-1개에서 -가 들어갈 자리를 찾을거야
	        // 근데 -가 0개부터 len-1개 들어갈 수 있어
	        // 즉, 서로 다른 위치 len-1개에서 R개 뽑을거야
//	        for(int r=0; r<len; r++) {
	            Arrays.fill(cal, '+');
	            combi(0,0,2);
//	        }
	            
	        int answer = 0;
	        return answer;
	   }
	

	// 반복문 돌릴 조합을 만들어볼까
	// 리턴값은 괄호의 조합 > 리턴값 void가 아닌건 처리하기 어려웠다...
	static void combi(int idx, int sidx, int R) {
	    // sidx는 들어갈 위치!
	    if(sidx == R) {
	    	for(char c: cal) {
	    		System.out.print(c);
	    	}
	    	System.out.println();
	        return;
	    }
	    else if(idx == len-1) return;
	    
	    cal[sidx] = '-';
	    combi(idx+1, sidx+1, R);
	    combi(idx+1, sidx, R);    
	}
}


