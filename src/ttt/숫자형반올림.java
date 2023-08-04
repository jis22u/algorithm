package ttt;

public class 숫자형반올림 {
    public static void main(String[] args) {
        double a = 341.678;
        double b = 341.123;

        double c = Math.round(b*100)/100.0;
        String d = String.format("%.2f", b);

        System.out.println(c);
        System.out.println(d);
    }
}
