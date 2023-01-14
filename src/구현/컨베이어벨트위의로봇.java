package 구현;

import java.io.*;
import java.util.*;

// 틀림
public class 컨베이어벨트위의로봇 {

	static int N, K;
	static int[] A;
	static boolean[] robot;
	public static void main(String[] args) throws IOException {

	/**
	 * 1) 회전=벨트랑 로봇이랑 int up, int down
	 * 2) 해당 칸에 로봇이 있고, 앞칸에 로봇이 없으며, 해당 칸의 내구도가 1이상 일때
	 * 3) 올리는 위치에 있는 칸의 내구도 >= 1 이면 로봇올려
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
			++step;
			
			// 1번
			up = (up+(2*N-1))%(2*N);
			down = (down+(2*N-1))%(2*N);
			turn(down);
			
			// 2번
			move(down);
			
			// 3번
			putUp(up);
			
			// 4번
			if(power()) {
				System.out.println(step);
				break;
			}

		}
		
	} //main
	
	static void turn(int down) {
		// 내리는 위치에 로봇 있으면 즉시 내리기
		robot[down] = false;
	}
	
	static void move(int down) {
		// 가장 먼저 벨트에 올라간 것부터!!
		for(int i=(2*N)-1; i>=0; i--) {
			// 로봇이 있고
			if(robot[i]) {
				// 앞에 로봇은 없으며, 내구도 1이상
				if(!robot[(i+1)%(2*N)] && A[(i+1)%(2*N)] >= 1) {
					// 한칸 전진 & 내구도 -1
					robot[i] = false;
					robot[(i+1)%(2*N)] = true;
					A[(i+1)%(2*N)] -= 1;
					
					// 근데 이동한 위치가 내리는 위치라면 즉시 내려
					if((i+1)%(2*N) == down) {
						robot[(i+1)%(2*N)] = false;
					}
				}
			}
		}
	}
	
	static void putUp(int up) {
		if(A[up] >= 1 && !robot[up]) {
			robot[up] = true;
			A[up] -= 1;
		}
	}
	
	
	static boolean power() {
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
