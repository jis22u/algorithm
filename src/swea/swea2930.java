package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 

// 최대힙 구현
public class swea2930 {
    
    static int size;
    static int[] heaparr;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            sb.append("#"+t);
            int N = Integer.parseInt(br.readLine());
            size = 0;
            heaparr = new int[N];
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                if( a==1 ) {
                    insert(Integer.parseInt(st.nextToken()));
                } else {
                    sb.append(" ").append(printmax());
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
         
        br.close();
         
    } //main
 
    // *최대힙* //
    // 삽입은 가장 마지막에
    static void insert(int value) {
		heaparr[++size] = value;

		// 정렬
		int cur = size;
		while (cur > 1 && heaparr[cur] > heaparr[cur / 2]) {
			int tmp = heaparr[cur];
			heaparr[cur] = heaparr[cur / 2];
			heaparr[cur / 2] = tmp;
			cur = cur / 2;
		}
    }
     
     
    // 삭제는 루트 노드의 원소
    static int printmax() {
        if(size == 0) {
            return -1;
        }
        int max = heaparr[1];
         
        // 정렬
        // 일단 마지막 원소를 맨 위로 올리기
        heaparr[1] = heaparr[size];
        // 마지막 원소 지워주기
        heaparr[size] = 0;                  
        // 자식들 중 최대값 그리고 그 인덱스
        // 더 간단한 코드는 swea에 있음
        int maxChild = 0;
        int j = 0;
        int i=1;
        while(2*i+1<size) {
//      for(int i = 1; i<size; ) {                          
            if(2*i+1<size) {
                if(heaparr[2*i] < heaparr[2*i+1]) {
                    maxChild = heaparr[2*i+1];
                    j = 2*i+1;
                } else {
                    maxChild = heaparr[2*i];
                    j = 2*i;
                }
                 
                // 자식들 중 최대값이 부모인 나보다 작다면 정렬 그만
                if(maxChild < heaparr[i]) {
                	break;
                } else {
                    int tmp = heaparr[i];
                    heaparr[i] = maxChild;
                    heaparr[j] = tmp;
                    i=j;
                }
            } else {
                if (heaparr[2*i] > heaparr[i]) {
                    int tmp = heaparr[2*i];
                    heaparr[2*i] = heaparr[i];
                    heaparr[i] = tmp;
                    i = i*2;
                } else {
                	break;
                }
            }   
        }
        
        size--;
        return max;
    }
     
} //end class