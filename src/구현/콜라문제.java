package 구현;

public class 콜라문제 {

	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int n = 20;
		int have = n;
        int answer = 0;
        int get = 0;
        while(true) {
            if(have < a) {break;}
            get = (have/a) * b;
            answer += get;
            have = (have%a) + get;
        }
       System.out.println(answer);

	}

}
