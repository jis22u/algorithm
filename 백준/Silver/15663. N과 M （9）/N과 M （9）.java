import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr, res;
    static boolean[] visited;
    static StringBuilder sb;
    static LinkedHashSet<String> setRes;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        visited = new boolean[max+1+N];
        res = new int[M];
        
        setRes = new LinkedHashSet<String>();
        
        perm(0);

        for(String s : setRes) {
            System.out.print(s);
        }
       
    } // main

    static void perm(int idx) {
        if(idx == M) {
            sb = new StringBuilder();
            for(int i=0; i<M; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.delete(sb.length()-1, sb.length());
            sb.append("\n");
            setRes.add(sb.toString());
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[arr[i]+i]) continue;

            res[idx] = arr[i];
            visited[arr[i]+i] = true;
            perm(idx+1);
            visited[arr[i]+i] = false;
        }
    } // perm
}