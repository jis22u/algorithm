package 완전탐색;

public class 숫자의표현 {
    static int answer, target;
    static int solution(int n) {
        answer = 0;
        target = n;
        for(int i=1; i<=target; i++) {
            search(i, i);
        }
        return answer;
    }

    static void search(int sum, int n) {
        if(sum == target) {
            answer++;
            return;
        } else if(sum > target) return;

        search(sum+n+1, n+1);
    }

    public static void main(String[] args) {
        System.out.println(solution(10000));
    }
}
