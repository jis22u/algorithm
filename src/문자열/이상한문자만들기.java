package 문자열;

public class 이상한문자만들기 {

    // toCharArray(), 4865, String.valueOf()
    // toUpperCase(), toLowerCase(), sb.setCharAt(i, '')
    // toUpperCase(), toLowerCase(), sb.append("")

    static String solution(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != ' ') {
                if(idx%2 == 0) {
                    String str = (s.charAt(i)+"").toUpperCase();
                    sb.append(str);
                } else {
                    String str = (s.charAt(i)+"").toLowerCase();
                    sb.append(str);
                }
                idx++;
            } else if(s.charAt(i) == ' ') {
                sb.append(" ");
                idx = 0;
            }
        }
        String answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        String[] str = {"try hello world", 	" abc ", "abc"};
        for(int i=0; i<3; i++) {
            System.out.println(solution(str[i]));
        }
    }
}
