package ttt;

public class 순열 {
    static int[] nums, result;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) {
        nums = new int[] {1,25,13,4};
        N = nums.length;
        result = new int[N];
        visited = new boolean[N];
        perm(0);
    }

    static void perm(int idx) {
        if(idx == N) {
            for(int i=0; i<N; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[i]) continue;

            result[idx] = nums[i];
            visited[i] = true;
            perm(idx+1);
            visited[i] = false;
        }
    }
}
