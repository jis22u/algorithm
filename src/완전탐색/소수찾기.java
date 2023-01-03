package 완전탐색;

// 아차ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
import java.util.*;

public class 소수찾기 {

	static String[] arr;
	static int len;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		num = num.replace('"', '\u0000');
		
		len = num.length();
		arr = new String[len];
		for(int i=0; i<len; i++) {
			arr[i] = num.charAt(i)+"";
		
		}
		
		check = new boolean[len];
		sel(0);
	
	} //main
	
	static boolean[] check;
	static void sel(int idx) {
		if(idx == len) {
			
			String str = "";
			for(int i=0; i<len; i++) {
				if(check[i]) {
					str += arr[i];
				}
			}
			
			System.out.println(str);
			return;
		}
		
		check[idx] = true;
		sel(idx+1);
		check[idx] = false;
		sel(idx+1);
	}

}

//"넘버스"를 숫자로 바꿔야해
//" 는 공백으로 replace 한다.
//각 문자를 원소로 갖는 배열을 만든다. 이때 숫자로 변환

//가능한 숫자의 조합을 만들어서 그게 소수냐? 판별한다.
//가능한 숫자의 조합은 어떻게 만들거냐
