package 문자열;

public class 문자열다루기기본 {
    static boolean solution(String s) {
        boolean answer = false;
        if(s.length() == 4 || s.length() ==6) {
            answer = true;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >=65) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] str = {"a234", "1234", "1234d55", "45"};
        for(int i=0; i<str.length; i++) {
            System.out.println(solution(str[i]));
        }
    }
}
