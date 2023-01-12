package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {

	static int N, K, A[];
	static boolean[] robot;
	public static void main(String[] args) throws IOException {

	/**
	 * 1) 회전=벨트랑 로봇이랑 int up, int down
	 * 2) 해당 칸에 로봇이 있고, 앞칸에 로봇이 없으며, 해당 칸의 내구도가 1이상 일때
	 * 3) 올리는 위치에 있는 칸의 내구도 != 0 이면 로봇올려
	 * 4) 내구도가 0인 칸의 개수 k개 이상이면, 종료
	 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 2N 길이의 벨트, 0인 칸의 개수 k이면 멈춰
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// N칸의 내구도
		st = new StringTokenizer(br.readLine());
		A = new int[2*N];
		for(int i=0; i<2*N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 벨트 위에 로봇 있어 없어?
		robot = new boolean[2*N];
		
		int step = 0;
		int up = 0;
		int down = N-1;
		while(true) {
			step++;
			
			// 1번 로봇상자 회전
			회전(down, up);
			
			
			// 2번
			이동(down, up);
			
			// 3번
			로봇올려(up);
			
			// 4번
			if(내구도()) {
				System.out.println(step);
				break;
			}

			// 1번 벨트 회전
			up = (up+(2*N-1))%(2*N);
			down = (down+(2*N-1))%(2*N);
		}
		
	} //main
	
	static void 회전(int down, int up) {
		// 로봇 회전
		for(int i=down-1; i>=up; i--) {
			// 로봇이 있으면 앞으로 한칸
			if(robot[i]) {
				robot[i] = false;
				robot[i+1] = true;
			}
			
			// 이때 내리는 위치에 도달하면 즉시 내리기
			if(i == down) {
				robot[i] = false;
			}
		}
	}
	
	static void 이동(int down, int up) {
		for(int i=down; i>=up; i--) {
			if(i == down && robot[down]) {
				robot[down] = false;
				continue;
			}
			
			if(robot[i] && !robot[i+1] && A[i]>=1) {
				robot[i] = false;
				robot[i+1] = true;
				A[i] -= 1;
			}
		}
	}
	
	static void 로봇올려(int up) {
		if(A[up] !=0 && !robot[up]) {
			robot[up] = true;
			A[up] -= 1;
		}
	}
	
	
	static boolean 내구도() {
		int cnt=0;
		for(int i=0; i<2*N; i++) {
			if(A[i] == 0) cnt++;
		}
		
		if(cnt >= K) {
			return true;
		}
		return false;
	}
	
	

}
