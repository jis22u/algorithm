package 수학;

public class 소수찾기 {

	public static void main(String[] args) {
		int n = 10;
		
		// 소수이면 F, 소수가 아니면 T
        boolean[] checkPrime = new boolean[n+1];
        checkPrime[0] = checkPrime[1] = true;
        
        for(int i=2; i<=n; i++) {
            // i가 소수이면
            if(!checkPrime[i]) {
                // i*n 은 소수가 아님
                for(int j=2; i*j <= n; j++) {
                    checkPrime[i*j] = true;
                }
            }
        }
        
        // 소수 개수 세기
        int answer = 0;
        for(int i=2; i<=n; i++) {
            if(!checkPrime[i]) {
                answer++;
            }
        }
        
        System.out.println(answer);
	}

}
