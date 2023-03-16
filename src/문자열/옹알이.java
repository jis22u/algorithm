package 문자열;

public class 옹알이 {

	public static void main(String[] args) {
		String[] babbling = {"aya", "yee", "u", "maa"};
		int answer = 0;
        int len = babbling.length;
        loop:
        for(int i=0; i<len; i++) {
            String word = turn(babbling[i]);
            char past = word.charAt(0);
            if (past != '0' && past != '1' && past != '2' && past != '3') {
                continue loop;
            }
            char cur = '0';
            boolean check = false;
            if(word.length() == 1) {
                if(past == '0' || past == '1' || past == '2' || past == '3') {
                    check = true;
                }
            } else {
                for(int j=1; j<word.length(); j++) {
                    cur = word.charAt(j);
                    if(cur == past) {
                        check = false;
                        break;
                    } else if (cur != '0' && cur != '1' && cur != '2' && cur != '3') {
                        check = false;
                        break;  
                    } else {
                        check = true;
                        past = cur;  
                    }
                }
            }
            if(check) answer++;
        }
        System.out.println(answer);
	}
	
	static String turn(String word) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        for(int i=0; i<4; i++) {
            if(word.contains(arr[i])) {
                word = word.replace(arr[i], i+"");
            }
        }
        return word;
    }

}
