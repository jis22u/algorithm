package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 데스나이트 {

    static class Node {
        int r,c,move;
        Node(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stR = Integer.parseInt(st.nextToken());
        int stC = Integer.parseInt(st.nextToken());
        int edR = Integer.parseInt(st.nextToken());
        int edC = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[N][N];    // 방문 처리, 갔던 곳은 또 갈 필요 없음
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(stR, stC, 0));
        visited[stR][stC] = true;

        int ans = Integer.MAX_VALUE;        // 최소 이동 횟수
        int[] dr = {-2, -2, 0, 0, 2, 2};    // 이동 가능 r
        int[] dc = {-1, 1, -2, 2, -1, 1};   // 이동 가능 c

        while(!q.isEmpty()) {
            Node node = q.poll();

            if(node.r == edR && node.c == edC) {
                ans = Math.min(ans, node.move);
            } else {
                for (int i = 0; i < 6; i++) {
                    int nr = node.r + dr[i];
                    int nc = node.c + dc[i];

                    if (nr >= N || nc >= N || nr < 0 || nc < 0) continue;
                    if(visited[nr][nc]) continue;
                    
                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc, node.move + 1));
                }
            }
        }

        ans = (ans == Integer.MAX_VALUE? -1 : ans);
        System.out.println(ans);
    }
}
