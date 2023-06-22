package 조합;

import java.util.*;

public class 괄호제거 {

    static class Bracket {
        int l, r;
        Bracket(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static String exp;
    static int size;
    static List<String> ansList;
    static List<Bracket> list;
    static Bracket[] selArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        exp = sc.nextLine();
        sc.close();

        // 괄호 판별하기
        Stack<Integer> stack = new Stack<>();       // '(' 괄호 저장
        list = new ArrayList<>();                   // '(', ')' 괄호쌍의 위치 저장, Bracket 활용
        for(int i=0; i<exp.length(); i++){
            if(exp.charAt(i) == '(') {
                stack.push(i);
            }

            if(exp.charAt(i) == ')') {
                list.add(new Bracket(stack.pop(), i));
            }
        }

        // 가능한 경우 모두 구하기
        // 조합
        ansList = new ArrayList<>();
        size = list.size();
        for(int R = size; R>0; R--) {
            selR = R;
            selArr = new Bracket[R];
            comb(0, 0);
        }

        Collections.sort(ansList);
        String before = "";
        String after = "";
        for(String ans:ansList) {
            after = ans;
            if(!after.equals(before)) {
                System.out.println(ans);
            }
            before = after;
        }
    }

    static int selR;
    static void comb(int idx, int sidx) {
        if(sidx == selR) {
            //selArr 안에 있는 괄호들 문자열에서 지우기
            StringBuilder sb = new StringBuilder(exp);
            for(int i=0; i<selArr.length; i++) {
                int l = selArr[i].l;
                int r = selArr[i].r;
                sb.setCharAt(l, '#');
                sb.setCharAt(r, '#');
            }
            String ans = sb.toString().replace("#","");
            ansList.add(ans);
            return;
        } else if(idx == size) return;

        selArr[sidx] = list.get(idx);
        comb(idx+1, sidx+1);
        comb(idx+1, sidx);
    }
}