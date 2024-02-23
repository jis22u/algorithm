import java.util.*;

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        str = str.toUpperCase();
        int len = str.length();
        int[] check = new int[26];

        for(int i=0; i<len; i++) {
            check[str.charAt(i)-65] += 1;
        }

        int max = 0;
        for(int i=0; i<26; i++) {
            max = Math.max(max, check[i]);
        }

        List<Character> list = new ArrayList<>();
        for(int i=0; i<26; i++) {
            if(max == check[i]) {
                char c = (char)(i+65);
                list.add(c);
            }
        }
        
        if(list.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(list.get(0));
        }
    }
}