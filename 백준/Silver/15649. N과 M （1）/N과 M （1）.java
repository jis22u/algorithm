import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];
        perm(0);
    } // main

    static void perm(int idx) {
        StringBuilder sb = new StringBuilder();
        if(idx == M) {
            for(int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
            return;
        }

        for(int i=1; i<N+1 ; i++) {
            if(visited[i]) continue;

            arr[idx] = i;
            visited[i] = true;
            perm(idx+1);
            visited[i] = false;
        }
    } // perm
}