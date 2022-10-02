package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 50퍼센트에서 틀림..
// 보호필름 마냥 삼진트리 처럼 풀고 싶었는데 안됐다
// 정답 풀이도 이미 삼진트리처럼 그려지긴 하지만...
// 보호필름 로직과 완전히 동일한 로직이 아니어서 그런가..
// ㅜㅜ재귀 어려워
public class baek18511_2 {

	static int N, K, max, len;
	static String[] num, sel;
	static int idx, sidx; 		
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String nn = st.nextToken();
		len = nn.length();					// 자연수 N의 자리수
		N = Integer.parseInt(nn);
		K = Integer.parseInt(st.nextToken());
		max = 0;
		
		sel = new String[len];						// 집합 K에서 선택한 수 저장
		st = new StringTokenizer(br.readLine());
		num = new String[K+1];						// 집합 K
		
		
		num[0] = 0+"";
		for(int i=1; i<K+1; i++) {
			num[i] = st.nextToken();
		}
		
		number(0,0);
		System.out.println(max);
	} //main
	
	static void number(int idx, int sidx) {
		if(sidx == len) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<len; i++) {
				sb.append(sel[i]);
			}
			int n = Integer.parseInt(sb+"");
			
			if(n <= N && max < n) {
				max = n;
			}
			return;
		}
 		if(idx >= K+1) return;
		
		sel[sidx] = num[idx];
		
		number(idx, sidx+1); 
		number(idx+1, sidx);
		number(idx+1, sidx+1);
		
	}

}