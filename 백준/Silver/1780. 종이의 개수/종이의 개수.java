import java.util.*;
import java.io.*;

class Main {

    static int N, minus, zero, one;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minus = zero = one = 0;

        search(0,0,N);
        System.out.println(minus+"\n"+zero+"\n"+one);
    } // main

    static void search(int row, int col, int len) {
        if(len < 1) return;

        if(isSame(row, col, len)) {
            if(arr[row][col] == -1) {
                minus++;
            } else if(arr[row][col] == 0) {
                zero++;
            } else {
                one++;
            }
        } else {
            for(int i=row; i<row+len;  i+=len/3) {
                for(int j=col; j<col+len; j+=len/3) {
                    search(i, j, len/3);
                }
            }
        }
    } // search
    
    static boolean isSame(int r, int c, int l) {
        int v = arr[r][c];
        for(int i=r; i<r+l; i++) {
            for(int j=c; j<c+l; j++) {
                if(v != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    } // isSame
}