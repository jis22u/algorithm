package 완전탐색;

// 순열인데, 먼가 하나 더 있다.....
// 프로그래머스
import java.util.*;

public class 소수찾기 {

	static String[] arr;
	static int len;
	static Set<Integer> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		// " 없애고
		num = num.replace("\"", "");
		// 배열에 담아보자
		len = num.length();
		arr = new String[len];
		for(int i=0; i<len; i++) {
			arr[i] = num.charAt(i)+"";
		
		}

		// 가능한 숫자 조합 담을 바구니
		set = new HashSet<>();
		// 가능한 숫자 조합 다 찾아보자
		for(int i=0; i<len; i++) {
			check = new boolean[len];	//F
			check[i] = true;
			sel(1, arr[i]);
		}
		
		// 7자리 정수 중 소수인것 찾기
		isPrime();
		
		// set 값들이 소수인지 판별
		int cnt = 0;
		for(int a:set) {
			if(!prime[a]) cnt++;
		}
		
		System.out.println(cnt);
		
		
	} //main
	
	// 가능한 숫자 조합 다 찾아보자
	static boolean[] check;
	static void sel(int cnt, String N) {
		if(cnt == len) {
			// 숫자로 바꿔주세요
			int num = Integer.parseInt(N);
			set.add(num);
			return;
		}
		if(cnt>len) return;
		
		
		for(int i=0; i<len; i++) {
			// 먼가 하나는 여기...
			// 고려 안되는 경우란, 선택하지 않은 경우
			// 그러니까 선택하지 않은 경우도 순열에 포함되어야 함
			if(check[i]) {
				sel(cnt+1, N);
				continue;
			}
			check[i] = true;
			sel(cnt+1, N+arr[i]);
			check[i] = false;
		}
	}
	
	// 소수 구하기
	static boolean[] prime;
	static void isPrime() {
		prime = new boolean[10000000];
		prime[0] = true;
		prime[1] = true;
		for(int i=0; i<10000000; i++) {
			if(!prime[i]) {
				for(int j=i*2; j<10000000; j+=i) {
					prime[j] = true;
				}
			}
		}
	}

}

//"넘버스"를 숫자로 바꿔야해
//" 는 공백으로 replace 한다.
//각 문자를 원소로 갖는 배열을 만든다.

//가능한 숫자의 조합을 만들어서 그게 소수냐? 판별한다.
//가능한 숫자의 조합은 어떻게 만들거냐
