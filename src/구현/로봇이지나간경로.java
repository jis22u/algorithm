package 구현;

import java.util.*;
import java.io.*;


public class 로봇이지나간경로
{
    static char[][] map;
    static char[] distance;

    static class Node {
        int i, j;
        char dis;

        Node(int i, int j, char dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }

    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        String line = "";
        for(int i=0; i<H; i++) {
            line = br.readLine();
            for(int j=0; j<W; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int ansR = 0;
        int ansC = 0;
        char ansD = '.';
        List<Character> ans = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        List<Character> list = new ArrayList<>();  // 조작 순서 저장
        boolean[][] visited = new boolean[H][W];
        int cnt = Integer.MAX_VALUE;

        distance = new char[]{'^', '>', 'v', '<'};
        int[] ddr = {-2,0,2,0};
        int[] ddc = {0,2,0,-2};
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if(map[i][j] == '#') {

                    // 여기서부터 모든 위치의 모든 방향 탐색
                    for(int d=0; d<4; d++) {
                        q = new LinkedList<>();
                        list = new ArrayList<>();
                        visited = new boolean[H][W];

                        q.add(new Node(i, j, distance[d]));
                        visited[i][j] = true;

                        while(!q.isEmpty()) {
                            Node n = q.poll();

                            for(int z=0; z<4; z++) {
                                int nnr = n.i + ddr[z];
                                int nnc = n.j + ddc[z];
                                int nr = n.i +dr[z];
                                int nc = n.j +dc[z];

                                if(nnr>=H || nnr<0 || nnc>=W || nnc<0) continue;
                                if(map[nnr][nnc] == '.' || map[nr][nc] == '.') continue;
                                if(visited[nnr][nnc]) continue;

                                // 바뀐 방향 info[0], 조작 info[1]
                                char[] info = searchDis(n.dis, ddr[z], ddc[z]);
                                if(info[1] == 'X') continue;

                                // 조작 순서 저장
                                if(info[1] == 'S') { list.add('A'); }
                                else if(info[1] == 'L') { list.add('L'); list.add('A'); }
                                else { list.add('R'); list.add('A'); }

                                // 큐에 저장
                                q.add(new Node(nnr, nnc, info[0]));
                                visited[nnr][nnc] = true;
                                visited[nr][nc] = true;
                            }
                        }

                        // if(cnt > list.size()) {
                        if(i==0 && j==7) {
                            ans = list;
                            ansR = i+1;
                            ansC = j+1;
                            ansD = distance[d];
                        }
                    }
                }
            }
        }

        System.out.println(ansR+" "+ansC);
        System.out.println(ansD);
        for(char c : ans) {
            System.out.print(c);
        }
    }

    // 바뀐 방향, 조작 구하는 메서드
    static char[] searchDis(char before, int r, int c) {
        // 이전 방향은 before인데, 이동한 인덱스는 (r,c)만큼이야
        char[] info = new char[2];

        int[] ddr = {0,0,2,-2};
        int[] ddc = {2,-2,0,0};

        // 바뀐 방향 구하기
        if(r==-2 && c==0) {info[0] = '^';}
        else if(r==0 && c==2) {info[0] = '>';}
        else if(r==2 && c==0) {info[0] = 'v';}
        else if(r==0 && c==-2) {info[0] = '<';}

        // 조작 구하기
        int beforeIdx = -1;
        int afterIdx = -3;
        for(int i=0; i<4; i++) {
            if(distance[i] == before) { beforeIdx = i; }
            if(distance[i] == info[0]) { afterIdx = i; }
        }

        if(beforeIdx==0 && afterIdx==3) { info[1] = 'L'; }
        else if(beforeIdx==3 && afterIdx==0) { info[1] = 'R'; }
        else if(afterIdx - beforeIdx == 1 ) { info[1] = 'R'; }
        else if(afterIdx - beforeIdx == -1 ) { info[1] = 'L'; }
        else if(before == info[0]) { info[1] = 'S'; }
        else { info[1] = 'X'; }

        return info;
    }
}