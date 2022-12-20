package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
	static class Move {
		int r, c;
		
		Move(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 세로, 가로 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] room = new int[N][M];
		// 청소 한 곳인지 아닌지 체크하기 위해
		boolean[][] check = new boolean[N][M];
		
		// 로봇 청소기가 있는 칸, 바라보는 방향
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		// 장소 상태, 빈칸:0, 벽:1
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 출발위치 일단 청소
		check[r][c] = true;
		
		// 청소개수
		int cnt = 1;
		
		// 예비 위치, 예비 방향
		int nr = 0;
		int nc = 0;
		int nextDir = 0;
		Move m = null;
		
		// 나 청소 했다 안했다
		boolean doClean = false;
		
		loop:
		while (true) {
			// 4방이므로 4번 반복
			for(int i=0; i<4; i++) {
				nextDir = searchLeft(dir);
				m = whereTo(nextDir);
				nr = r + m.r;
				nc = c + m.c;
				
				if(nr>=N || nc>=M || nr<0 || nc<0) continue;
				if(check[nr][nc] || room[nr][nc] == 1) {
					dir = nextDir;
				} else {
					doClean = true;
					r = nr;
					c = nc;
					dir = nextDir;
					check[r][c] = true;
					cnt++;
					break;
				}
			}
			
			// 한 칸 후진
			if(!doClean) {
				m = whereBack(dir);
				nr = r + m.r;
				nc = c + m.c;
				
				if(nr>=N || nc>=M || nr<0 || nc<0) continue;
				if(room[nr][nc] == 1) break loop;
				
				r = nr;
				c = nc; 
			}

			// doClean 초기화
			doClean = false;
		}
		
		System.out.println(cnt);
		
		
		
	} // main
	
	// 현재 방향 기준으로 왼쪽방향 무엇?
	static int searchLeft(int dir) {
		if(dir == 0) return 3; // 북쪽 > 서쪽
		else if(dir == 1) return 0; // 동쪽 > 북쪽
		else if(dir == 2) return 1; // 남쪽 > 동쪽
		else return 2; // 서쪽 > 남쪽
	}
	
	// nr, nc를 얼마나 움직여?
	static Move whereTo(int dir) {
		if(dir == 0) return new Move(-1,0);
		else if(dir == 1) return new Move(0,1);
		else if(dir == 2) return new Move(1,0);
		else return new Move(0,-1);
	}
	
	// 한 칸 후진한다면 어디로?
	static Move whereBack(int dir) {
		if(dir == 0) return new Move(1,0);
		else if(dir == 1) return new Move(0,-1);
		else if(dir == 2) return new Move(-1,0);
		else return new Move(0,1);
	}
	
}
// 정현 코드

