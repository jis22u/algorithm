package 문자열;

public class 이상한문자만들기2 {

    // String[] = split("")
    // String.valueOf(문자열배열) > 결과값의 주소가 찍힘
    
    static String solution(String s) {
        s = s.toUpperCase();
        String[] arr = s.split("");
        int idx = 0;

        for(int i=0; i<s.length(); i++) {
            if (arr[i].equals(" ")) {
                idx = 0;
            } else {
                if(idx%2 == 1) arr[i] = arr[i].toLowerCase();
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            sb.append(str);
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
