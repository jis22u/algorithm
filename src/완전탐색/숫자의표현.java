package 완전탐색;

public class 숫자의표현 {
    static boolean[] visited;
    static int answer, target;
    public static void main(String[] args) {
        int n = 15;
        visited = new boolean[n+1];
        answer = 0;
        target = n;
        search(0);
        System.out.println(answer);
    }

    static void search(int sum) {
        if (sum == target) {
            answer++;
            System.out.println(sum);
            for(int i=1; i<=target; i++) {
                if(visited[i]) {
                    System.out.print(i+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=target; i++) {
            if(visited[i]) continue;
            if(sum+i > target) {
                break;
            }

            visited[i] = true;
            search(sum+i);
            visited[i] = false;
        }
    }
}
