package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// case1.
// Set<Integer> set = new HashSet<>();
// 을 활용해서 풀 수도 있다.
// 숫자가 중복되어 나오는지 안나오는지만 체크하면 되기 때문이다

// case2. 영묵님 코드
// CT적 사고? 일단 true로 바꾸고 코드 윗줄에 조건문 걸어서 중복 여부 판단하기
// *질문* static 메서드에서 return이 중복 for문 안에 있든 어디에 있든 위치에 상관없이 return을 만나면
//        여러 return 중 해당 return에서 바로 전체 check() 메서드를 빠져나와서 호출한 곳으로 간다??

// 스도쿠 검증
public class swea1974 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] board;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 스도쿠 입력 받기
			board = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 검증 숫자
			int[] check = new int[10];
			boolean flag = true;

			// 가로 검증
			for (int i = 0; i < 9; i++) {
				check = new int[10];
				for (int j = 0; j < 9; j++) {
					if (check[board[i][j]] == 1) {
						flag = false;
						break;
					} else {
						check[board[i][j]]++;
					}
				}
			}

			// 세로 검증
			if (flag) {
				for (int i = 0; i < 9; i++) {
					check = new int[10];
					for (int j = 0; j < 9; j++) {
						if (check[board[j][i]] == 1) {
							flag = false;
							break;
						} else {
							check[board[j][i]]++;
						}
					}
				}
			}

			// 박스 검증
			if (flag) {
				for (int i = 0; i < 9; i += 3) {
					for (int j = 0; j < 9; j += 3) {
						check = new int[10];
						for (int p = 0; p < 3; p++) {
							for (int q = 0; q < 3; q++) {
								if (check[board[i + p][j + q]] == 1) {
									flag = false;
									break;
								} else {
									check[board[i + p][j + q]]++;
								}
							}
						}
					}
				}
			}

			if (flag) {
				bw.write("#" + t + " " + "1");
			} else {
				bw.write("#" + t + " " + "0");
			}

			bw.flush();
			bw.newLine();

		} // for
		bw.close();
		br.close();

	} // main

}
