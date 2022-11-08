package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇프로젝트 {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			int x = Integer.parseInt(str);
			int n = Integer.parseInt(br.readLine());
			int[] blocks = new int[n];
			for (int i = 0; i < n; i++) {
				blocks[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(blocks);
			
			int st = 0;
			int ed = n-1;
			int key = x * 10000000;
			String ans = "danger";
			while(st<ed) {
				int sum = blocks[st] + blocks[ed];
				
				if(sum < key) {
					st++;
				} else if(sum > key) {
					ed--;
				} else {
					ans = "yes ";
					break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			if(ans.equals("yes ")) {
				System.out.println(sb.append(ans).append(blocks[st]+" ").append(blocks[ed]).toString());
			} else {
				System.out.println(ans);
			}
		}
		
		
	} //main

}

