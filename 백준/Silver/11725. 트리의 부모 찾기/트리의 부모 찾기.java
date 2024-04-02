import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static int N;
    static boolean[] visited;
    static int[] parents;
    static List<Integer>[] pList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;
        pList = new ArrayList[N+1];

        for(int i=0; i<N+1; i++) {
            pList[i] = new ArrayList<>();
        }

        StringTokenizer stz;
        for(int i=0; i<N-1; i++) {
            stz = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stz.nextToken());
            int ed = Integer.parseInt(stz.nextToken());
            pList[st].add(ed);
            pList[ed].add(st);
        }

        dfs(1);
        
        for(int i=2; i<N+1; i++) {
            System.out.println(parents[i]);
        }
        
    } // main

    static void dfs(int r) {
        
        for(int c : pList[r]) {
            if(visited[c]) continue;
            
            parents[c] = r;
            visited[c] = true;
            dfs(c);
        }
    } // dfs
}