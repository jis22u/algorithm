package 순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 규영이와 인영이의 카드게임
public class swea6808 {
	
	
	static int[] kyu, in, InCase;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			boolean[] card = new boolean[19];
			kyu = new int[9];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				card[kyu[i]] = true;
			}
			
			int j = 0;
			in = new int[9];
			for(int i=1; i<19; i++) {
				if(!card[i]) {
					in[j] = i;
					j++;
				}
			}
			
			
			// 규영이가 이기는 경우와 지는 경우 cnt
			win = 0;
			lose = 0;
			visited = new boolean[9];
			InCase = new int[9];
			perm(0);
			
			System.out.println("#"+t+" "+win+" "+lose);
		}
		
	} // main
	

	static int win;
	static int lose;
	static void perm(int idx) {
		// 인영이 경우의 수 나오면 규영이 승패 가르기
		if(idx == 9) {
			int scorein = 0;
			int scorekyu = 0;
			
			for(int i=0; i<9; i++) {
				if(InCase[i]>kyu[i]) {
					scorein += (InCase[i]+kyu[i]);
				} else {
					scorekyu += (InCase[i]+kyu[i]);
				}
			}
			
			if(scorein > scorekyu) {
				lose++;
			} else {
				win++;
			}
			
			return;
		}
		
		// 인영이 경우의 수 구하기
		for(int i=0; i<9; i++) {
			if(visited[i]) continue;
			
			InCase[idx] = in[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
	
	
}
