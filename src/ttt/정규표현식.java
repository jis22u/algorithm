package ttt;

public class 정규표현식 {
    static void solution(String s) {
//        String[] str = s.split("[A-Z]");
//        String[] str = s.split("[A-z]");
        String[] str = s.split("[0-9]");

        System.out.println("개수: " + str.length);
        for(String ss: str) {
            System.out.println(ss);
        }
    }

    public static void main(String[] args) {
        String[] str = {"1234", "a234", "4A5"};
        for(int i=0; i<str.length; i++) {
            solution(str[i]);
        }
    }
}
