package ttt;

// baek1747
// 소수와 팰린드롬_김소진 코드
public class valueOf {

	public static void main(String[] args) {

		// toString()과 String.valueOf()는 Object 값을 String 형으로 변환할 때 주로 사용하는 메소드이다.
		String str = String.valueOf(102);
		System.out.println(str);
		
		
		StringBuilder sb = new StringBuilder(str);
		String reversedStr = sb.reverse().toString();
//		String.valueOf(sb.reverse());
		System.out.println(reversedStr);
	}

}
