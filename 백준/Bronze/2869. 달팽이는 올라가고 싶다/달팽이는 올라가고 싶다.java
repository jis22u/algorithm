import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken()); 
        int V = Integer.parseInt(st.nextToken());       

        
        int days = (V - B) / (A - B);
        if((V - B) % (A - B) != 0) days++;

        System.out.println(days);
        
    }
}