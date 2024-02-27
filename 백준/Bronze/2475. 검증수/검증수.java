import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=0; i<5; i++) {
            int v = Integer.parseInt(st.nextToken());
            sum += v*v;
        }
        
        int ans = sum%10;
        System.out.println(ans);
    }
}