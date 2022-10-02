package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek나무재테크 {

	static int N;
	static int[][] land, nouri;
	static PriorityQueue<Tree> trees;
	static Queue<Tree> alive;
	static Queue<Tree> dead;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		trees = new PriorityQueue<>();
		alive = new LinkedList<>();
		dead = new LinkedList<>();

		N = Integer.parseInt(st.nextToken()); // 땅 크기, 인덱스는 1부터 시작
		int M = Integer.parseInt(st.nextToken()); // M개의 나무
		int K = Integer.parseInt(st.nextToken()); // K년 후?

		land = new int[N + 2][N + 2];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				land[i][j] = 5;
			}
		}

		// 겨울 양분
		nouri = new int[N + 2][N + 2];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				nouri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구매한 나무 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x, y, z));
		}

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}

		System.out.println(trees.size());

	} // main

	static class Tree implements Comparable<Tree> {
		// 나무의 좌표, 나이
		int x, y, age;

		Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}

	// 봄
	static void spring() {
		while (!trees.isEmpty()) {
			Tree t = trees.poll();

			int nr = t.x;
			int nc = t.y;
			int na = t.age;

			if (land[nr][nc] - na >= 0) {
				land[nr][nc] -= na;
				alive.add(new Tree(nr, nc, na + 1));
			} else {
				dead.add(t);
			}
		}
	}

	// 여름
	static void summer() {
		while (!dead.isEmpty()) {
			Tree d = dead.poll();
			int nr = d.x;
			int nc = d.y;
			int age = d.age;
			land[nr][nc] += (age / 2);
		}
	}

	// 가을
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static void fall() {
		while (!alive.isEmpty()) {
			Tree adult = alive.poll();

			int nr = adult.x;
			int nc = adult.y;
			int age = adult.age;
			
			trees.add(new Tree(nr, nc, age));
			
			if (age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int x = nr + dr[i];
					int y = nc + dc[i];

					if (x < 1 || y < 1 || x >= N + 1 || y >= N + 1) continue;
					trees.add(new Tree(x, y, 1));
				}
			}
		}
	}

	// 겨울
	static void winter() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				land[i][j] += nouri[i][j];
			}
		}
	}

}
