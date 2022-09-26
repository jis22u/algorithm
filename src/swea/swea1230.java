package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// swea암호문3
// 리스트 활용
public class swea1230 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		StringTokenizer st;
		for(int t=1; t<=10; t++) {
			// 암호문
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				list.add(Integer.parseInt(st.nextToken())); 				
			}
			
			// 명령어
			int c = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<c; i++) {
				String comm = st.nextToken();
				if(comm.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int p=x; p<x+y; p++) {
						list.add(p, Integer.parseInt(st.nextToken()));
					}
				} else if(comm.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int p=x; p<x+y; p++) {
						list.remove(p);
					}
				} else if(comm.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for(int p=0; p<y; p++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			sb.append("#"+t+" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)+" ");
			}
			
			System.out.println(sb.delete(sb.length()-1, sb.length()));
			sb.setLength(0);
		}
	} // main

}
