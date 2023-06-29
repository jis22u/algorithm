package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어 {
	static int[] isExisted, checked;
	static int len, strLen;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String target = br.readLine();
        len = target.length();

        isExisted = new int[26];          // 0부터 25까지 == A부터 Z까지 
        for(int i=0; i<len; i++) {
             isExisted[target.charAt(i)-'A']++;
        }


        int ans = 0;
        for(int i=0; i<N-1; i++) {
            String str = br.readLine();
            checked = new int[26];
            strLen = str.length();
            for(int l=0; l<strLen; l++) {
                checked[str.charAt(l)-'A']++;
            }
            
            if(len == strLen) {
            	if(sameFormat() || replaceOne()) { ans++; }
            } else if(Math.abs(len - strLen) == 1){
            	if(removeOne() || addOne()) { ans++;}
            }
        }
        System.out.println(ans);

	}

    static boolean sameFormat() {
    	for(int i=0; i<26; i++) {
    		if(isExisted[i] != checked[i]) { return false; }
    	}
    	return true;
    }
    
    static boolean removeOne() {
    	int cnt = 0;
    	for(int i=0; i<26; i++) {
    		if(isExisted[i] == checked[i]) {
    			cnt++;
    		}
    	}
    	if(cnt == Math.min(len, strLen)) { return true; }
    	else { return false; }
    }
    
    static boolean addOne() {
    	int cnt = 0;
    	for(int i=0; i<26; i++) {
    		if(isExisted[i] != checked[i]) {
    			cnt++;
    		}
    	}
    	if(cnt == 1) {  return true; }
    	else { return false; }
    }
    
    static boolean replaceOne() {
    	int cnt = 0;
    	boolean flag = true;
    	for(int i=0; i<26; i++) {
    		if(isExisted[i] != checked[i]) {
    			cnt++;
    			if( flag && Math.abs(isExisted[i] - checked[i]) != 1) { flag = false;}
    		}
    	}
    	if(cnt == 2 && flag) { return true; }
    	else { return false; }
    }

}
