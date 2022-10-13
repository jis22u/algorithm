package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 

// swea4698
public class 테네스의특별한소수 {
 
    public static void main(String[] args) throws IOException {     
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t++) {
        	// 소수 판별---------------------------------
        	// 소수는 false
            // 1은 소수가 아니므로 제외
        	boolean[] prime = new boolean[1000001];
        	prime[0] = true;
        	prime[1] = true;
        	
            for(int i=2; i<=1000000; i++){
                // prime[i]가 소수라면
                if(!prime[i]){
                	// i의 곱들은 소수가 아니므로
                    for(int j=i*2; j<=1000000; j+=i) { 
                    	prime[j] = true;         
                    }
                }        
            } 
            
            // -------------------------------------------
             
            st = new StringTokenizer(br.readLine());
            String D = st.nextToken();
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
             
            int cnt = 0;
            for(int i = A ; i <= B ; i++) {
                if(!prime[i]) {
                    if(String.valueOf(i).contains(D)) {
                        cnt++;
                    }
                }
            }
            
            sb = new StringBuilder();
            sb.append("#"+t+" ");
            sb.append(cnt).append("\n");

            System.out.print(sb.toString());
        }
         
    }
}
