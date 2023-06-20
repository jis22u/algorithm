package 순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로 {
    static int N, max;
    static int[] arrOrder, arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 가능한 배열의 조합 모두 구하기
        max = Integer.MIN_VALUE;
        arrOrder = new int[N];
        visited = new boolean[N];
        perm(0);

        System.out.println(max);
    }

    static void perm(int idx) {
        if(idx == N) {
            // 2. 순열이 완성되면
            int sum = 0;
            for(int i=0; i<N-1; i++) {
                sum += Math.abs(arrOrder[i]-arrOrder[i+1]);
            }
            if(sum>max) {
                max = sum;
            }
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                arrOrder[idx] = arr[i];
                visited[i] = true;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
