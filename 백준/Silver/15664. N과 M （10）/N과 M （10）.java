import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[] nums, res;
    static LinkedHashSet<String> set;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        res = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        set = new LinkedHashSet<>();
        search(0, 0);

        for(String s : set) {
            System.out.println(s);
        }
    } // main

    static void search(int idx, int sidx) {
        if(sidx >= M) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<M; i++) {
                sb.append(res[i]+" ");
            }
            set.add(sb.toString());
            return;
        } else if(idx == N) return;
        
        res[sidx] = nums[idx];
        search(idx+1, sidx+1);
        search(idx+1, sidx);
    } // search
}