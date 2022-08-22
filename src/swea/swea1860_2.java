package swea;

import java.io.*;
import java.util.*;
 
 
public class swea1860_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr=new int[11112];
            for(int j=0;j<n;j++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }
            int cnt=0;
            boolean flag=true;
            if(arr[0]>0)
                flag=false;
            else {
            	// 이 경우는 손님 입장에서 생각한 것
                for(int j=1;j<11112;j++) {
                    if(j%m==0) {
                        cnt+=k;
                    }
                    if(arr[j]>cnt) {
                        flag=false;
                        break;
                    }else {
                        cnt-=arr[j];
                    }
                }
            }
            if(flag) {
                sb.append("#"+(i+1)+" Possible\n");
            }else {
                sb.append("#"+(i+1)+" Impossible\n");
            }
        }
        System.out.println(sb);
    }
}
