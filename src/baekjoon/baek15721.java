package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek15721 {

   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int a = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      int b = Integer.parseInt(br.readLine());
      
      int n = 2;
      int cnt0 = 0;
      int cnt1 = 0;
      
      outer:
      while(true) {
    	  for(int i=0; i<4; i++) {
    		  if(i % 2 == 0) {
    			  cnt0++;
    		  } else {
    			  cnt1++;
    		  }
    		  
    		  if(b==0 && cnt0==t) {
    			  System.out.println((cnt0+cnt1-1)%a);
    			  break outer;
    		  }
    		  
    		  if(b==1 && cnt1==t) {
    			  System.out.println((cnt0+cnt1-1)%a);
    			  break outer;
    		  }
    	  }
    	  
    	  
    	  for(int i=0; i<n; i++) {
    		  cnt0++;
    		  
    		  if(b==0 && cnt0==t) {
    			  System.out.println((cnt0+cnt1-1)%a);
    			  break outer;
    		  }
    	  }
    	  
    	  for(int i=0; i<n; i++) {
    		  cnt1++;
    		  
    		  if(b==1 && cnt1==t) {
    			  System.out.println((cnt0+cnt1-1)%a);
    			  break outer;
    		  }
    	  }
    	  
    	  n++;
      }
      
      
      
      br.close();
      
   } //main

}