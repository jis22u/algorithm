package ttt;

public class StringBuilder_insert {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		
		// append함수는 마지막에 문자열을 추가
		sb.append("11231 1231 1231 151 321 516");
		
		sb.insert(3, "aaaa");
		
		System.out.println(sb);
		
		
		
//		char charToAdd1 = 'A';
//        char charToAdd2 = 'g';
//
//        String alex = "Alex got Grade in the School";
//        String bob = "While Bob ot Grade C";
//
//        String alexResult = alex.substring(0, 15) + charToAdd1 +alex.substring(15);
//        String bobResult = bob.substring(0, 10) + charToAdd2 + bob.substring(10);
//        System.out.println(alexResult);
//        System.out.println(bobResult);
		
	}

}
