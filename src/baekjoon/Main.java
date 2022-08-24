package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


//컵홀더
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Character> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		
		// 일단 처음에 넣고
		list.add('*');
		for(int i=0; i<n; i++) {
			char c = str.charAt(i);
			
			// 컵홀더+자리
			if(c == 'S') {
				list.add(c);
				list.add('*');
			} else if(c =='L') {
				list.add(c);
				list.add('L');
				list.add('*');
				i++;
			} 
			
		}

		
		// 컵홀더 사용 못하는 사람 카운트
		int cnt=0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == '*') {
				i = i+1;
			} else {
				if(list.get(i+1) != '*') {++cnt;}
				else {i = i+1;}
			}
		}
		
		System.out.println(n-cnt);
		

	} //main

}
