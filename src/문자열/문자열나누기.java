package 문자열;

public class 문자열나누기 {

    public static void main(String[] args) {
        String s = "banana";
        int answer = 0;
        char first = '0';
        int x = 0;
        int y = 0;
        while(s.length() != 0) {
            first = s.charAt(0);
            for(int i=0; i<s.length(); i++) {
                if(first == s.charAt(i)) { x++; }
                else { y++; }
                if(x == y || i == s.length()-1) {
                    s = s.substring(i+1, s.length());
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
