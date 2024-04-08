import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int cnt = 0;
        Stack<Character> stick = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stick.push(c); 
            } else {
                stick.pop();
                if (str.charAt(i-1) == '(') {
                    cnt += stick.size();
                } else {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        
    } // main
}