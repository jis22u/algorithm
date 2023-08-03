package BFS;

import java.util.*;

public class 미로탈출 {

    /*  S : 시작 지점
        E : 출구
        L : 레버
        O : 통로
        X : 벽
        벽은 통과할 수 없지만, 모든 통로, 출구, 레버, 시작점은 여러 번 지날 수 있음
        출구는 레버가 당겨지지 않아도 지나갈 수 있음 */

    static class Node {
        int r,c,t;
        char v;

        Node(int r, int c, char v, int t) {
            this.r = r;
            this.c = c;
            this.v = v;
            this.t = t;
        }
    }


    /*
        여러번 지나갈 수 있다해서 방문처리를 안해도 될 것 같지만, 방문처리를 하는 이유?
        최단거리라고 했기 때문에 사실상 방문처리 하는 것
        BFS이기 때문
     */
    static public int solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        // 출발지점 찾기
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(maps[i].charAt(j) == 'S') {
                    q.add(new Node(i,j,'S',0));
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        int answer = -1;

        // S > L
        while(!q.isEmpty()) {
            Node n = q.poll();

            if(n.v == 'L') {
                q.clear();
                visited[n.r][n.c] = true;
                q.add(new Node(n.r, n.c, n.v, n.t));
                break;
            }

            for(int d=0; d<4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];

                if(nr>=row || nc>=col || nr<0 || nc<0) continue;
                if(maps[nr].charAt(nc) == 'X') continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new Node(nr,nc,maps[nr].charAt(nc),n.t+1));
            }
        }

        // L > E
        // 일단 S에서 L까지 방문처리 하면서 최단거리 구하고
        // S에서 L까지 지나왔던 거리를 E까지 가기 위해 또 지날 수 있으니까 (여러 번 지날 수 있기 때문에 )
        // 방문처리 했던 거 초기화 (반례: SEOOL)
        visited = new boolean[row][col];
        while(!q.isEmpty()) {
            Node n = q.poll();

            if(n.v == 'E') {
                answer = n.t;
                break;
            }

            for(int d=0; d<4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];

                if(nr>=row || nc>=col || nr<0 || nc<0) continue;
                if(maps[nr].charAt(nc) == 'X') continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new Node(nr,nc,maps[nr].charAt(nc),n.t+1));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }
}
