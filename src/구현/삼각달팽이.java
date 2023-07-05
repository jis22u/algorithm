package 구현;

public class 삼각달팽이 {
    public static void main(String[] args) {
        int n = 6;
        int[][] arr = new int[n+1][n+1];

        int r = 0;
        int c = 1;
        int v = 0;
        int m = n;
        while(m>0) {
            for(int cnt=1; cnt<=m; cnt++) {
                arr[++r][c] = ++v;
            }
            --m;
            for(int cnt=1; cnt<=m; cnt++) {
                arr[r][++c] = ++v;
            }
            --m;
            for(int cnt=1; cnt<=m; cnt++) {
                arr[--r][c] = ++v;
            }
            for(int cnt=1; cnt<=m; cnt++) {
                --c;
            }
            --m;
        }

        int[] answer = new int[(n*(n+1))/2];
        int k = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(arr[i][j] == 0) continue;
                answer[k++] = arr[i][j];
                System.out.print(arr[i][j]+" ");
            }
        }
    }
}
