package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {

    static class Home {
        int r,c;
        Home(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Chicken{
        int r,c;
        Chicken(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int M, m, chickenLen, ans;
    static Chicken[] selected;
    static ArrayList chickenList, homeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       // 도시의 크기
        M = Integer.parseInt(st.nextToken());       // 살아남은 치킨집 최대 개수

        homeList = new ArrayList();
        chickenList = new ArrayList();

        int[][] city = new int[N+1][N+1];
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1) homeList.add(new Home(i, j));
                if(city[i][j] == 2) chickenList.add(new Chicken(i, j));
            }
        }

        ans = Integer.MAX_VALUE;

        // 치킨집 chickenLen 중에서 M개부터 1개 선택하자
        chickenLen = chickenList.size();
        for(m=M; m>=1; m--) {
            selected = new Chicken[m];
            select(0,0);
        }

        System.out.println(ans);
    }

    // 치킨집 최대 M개 선택하자
    static void select(int idx, int sidx) {
        if(sidx == m) {
            // 치킨집 m 개 모두 선택했으면 도시의 치킨거리 구하러
            ans = Math.min(distance(), ans);
            return;
        }
        if(idx == chickenLen) return;

        selected[sidx] = (Chicken) chickenList.get(idx);
        select(idx+1, sidx+1);
        select(idx+1, sidx);
    }

    // 도시의 치킨거리 구하자
    static int distance() {
        int len = homeList.size();
        int selLen = selected.length;
        int sum = 0;
        for(int i=0; i<len; i++) {
            int dis = Integer.MAX_VALUE;
            Home h = (Home) homeList.get(i);
            for(int j=0; j<selLen; j++) {
                Chicken c = selected[j];
                dis = Math.min(dis, Math.abs(h.r-c.r)+Math.abs(h.c-c.c));
            }
            sum += dis;
        }
        return sum;
    }
}
