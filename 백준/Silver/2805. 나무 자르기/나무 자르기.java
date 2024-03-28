import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];  // 나무 높이 배열

        st = new StringTokenizer(br.readLine());
        int r = 0;
        for(int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(r<trees[i]) {
                r = trees[i];
            }
        }

        int H = 0;
        int l = 0;
        long sum = 0;
        while(l<r) {
            H = (l+r)/2;
            for(int i=0; i<N; i++) {
                if(trees[i]<=H) continue;
                if(trees[i]>H) {
                    sum += (trees[i] - H);
                }
            }

            if(sum < M) {
                r = H;
            } else {
                l = H+1;
            }
            sum = 0;
        }
        System.out.println(l-1);
    } // main
}