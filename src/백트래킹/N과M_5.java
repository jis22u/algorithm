package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {

    static int[] arr, select;
    static int N, M;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        br.close();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

//        sb = new StringBuilder();
        select = new int[M];
        makeSeq(0);

        System.out.println(sb);
    }

    static void makeSeq(int idx) {
        if(idx == M) {
            for(int i=0; i<M; i++) {
                sb.append(select[i]+" ");
            }
//            sb.delete(sb.length()-1, sb.length());   없애도 정답이네
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if(isVisited[i]) continue;

            isVisited[i] = true;
            select[idx] = arr[i];
            makeSeq(idx+1);
            isVisited[i] = false;
        }
    }
}
