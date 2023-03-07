package 완전탐색;

public class 모음사전2 {
	static int cnt, answer;
	static String target;
	static char[] vowels;

	public static void main(String[] args) {
		target = "I";
		vowels = new char[] { 'A', 'E', 'I', 'O', 'U' };
		answer = cnt = 0;
		makeWord("");
		System.out.println(answer);
	}

	static void makeWord(String str) {
		// 그것이 찾고자 하는 단어와 같은가?
		if (str.equals(target)) {
			answer = cnt;
			return;
		}

		// 5자리 모두 만들었으면
		if (str.length() >= 5)
			return;

		// 단어를 만들어보자
		for (int i = 0; i < 5; i++) {
			cnt++; // 몇번째로 만들어지는 카운트
			makeWord(str + vowels[i]);
		}
	}
}