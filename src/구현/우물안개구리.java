package 구현;

import java.util.*;
import java.io.*;


public class 우물안개구리
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] weight = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] imtheone = new boolean[N];
        Arrays.fill(imtheone, true);    // 일단 모두 T, 혼자 남는 사람 때문에 추가적으로 고려안해도 됨
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken())-1;
            int p2 = Integer.parseInt(st.nextToken())-1;

            // 둘이 무게 비교
            if(weight[p1] > weight[p2]) {
                imtheone[p2] = false;
            } else if (weight[p1] < weight[p2]) {
                imtheone[p1] = false;
            } else {    // 둘이 무게 같으면 아무도 자신이 최고라고 생각 안 함
                imtheone[p2] = false;
                imtheone[p1] = false;
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++) {
            if(imtheone[i]) ans++;
        }

        System.out.println(ans);
    }
}
