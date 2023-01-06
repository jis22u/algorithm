package 완전탐색;

// 시간초과
import java.util.Scanner;

public class A와B2 {

	static String S,T;
	static int ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		S = sc.next();
		T = sc.next();
		
		StringBuilder sb = new StringBuilder();
		sb.append(S);
		ans = 0;
		search(sb, sb.length());
		
		System.out.println(ans);
	} // main
	
	// 하나씩 붙여보면서 찾아보자
	static void search(StringBuilder target, int len) {
		if(len == T.length()) {
			String str = target.toString();
			// 찾았다
			if(str.equals(T)) {
				ans = 1;
			}
			return;
		} 
		else if(len > T.length()) {
			// 찾고자 하는 문자열의 길이를 이미 지났기 때문에 볼 필요가 없다.
			return;
		}
		
		search(target.append("A"), len+1);
		target.delete(len,len+1);
		search(target.append("B").reverse(), len+1);
		target.reverse().delete(len,len+1);
	}

}
