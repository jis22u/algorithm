package swea;

import java.util.Scanner;


// 소진님 코드
// 1. 최대 이동수만큼 칸을 나눠
// 2. 그 사이에서 충전기 있는 정류장 찾아. 
// 3. 거기서 충전해서 k를 최대치로 끌어올리고, 그 정류장에서 다시 시작해
public class 전기버스2 {
     
    public static void main(String[] args) {    
         
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
         
        boolean[] map;
        int k, n, m, idx, stop, ans;
         
        int T = sc.nextInt();       
        for(int tc=1; tc<=T; tc++) {
        	// K 최대 이동 수, N 종점 번호, M 충전기 설치된 정류장 개수
            k = sc.nextInt();
            n = sc.nextInt();
            m = sc.nextInt();
             
            map = new boolean[n+k];
            while(m-- > 0)
                map[sc.nextInt()] = true;
             
            idx = 0;
            stop = 0;
            ans = 0;
             
            all:
            while(idx < n) {
                 
                for(int i=idx; i<=idx+k; i++) {
                    if(map[i])
                        stop = i;
                    if(i >= n)
                        break all;              
                }
                 
                if(stop == idx) {
                    ans = 0;
                    break;
                }
                 
                ans++;              
                idx = stop;         
            }
             
             
            sb.append("#" + tc + " " + ans + "\n");                 
             
        }
         
        System.out.println(sb);
    }
     
}