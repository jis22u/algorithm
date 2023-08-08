package ttt;

public class 이진수1의개수 {
    public static void main(String[] args) {
        /*
         정수를 매개변수로 넣었을 떄
         이진수에서 1의 개수를 세어주는 함수이다.
        */
        int a = 78;
        int cnt = Integer.bitCount(a);

        System.out.println(cnt);
    }
}
