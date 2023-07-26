package 문자열;

import java.util.*;
import java.io.*;


public class 비밀메뉴
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String operation = br.readLine().toString();
        String user = br.readLine().toString();

        if(user.contains(operation)) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}