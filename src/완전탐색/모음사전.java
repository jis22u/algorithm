package 완전탐색;

public class 모음사전 {
	static int cnt, answer;
	static String target;
	static char[] sel, vowels;

	public static void main(String[] args) {
		target = "AAAE";
		sel = new char[5];
		vowels = new char[] { 'A', 'E', 'I', 'O', 'U' };
		answer = cnt = 0;
		makeWord(0);
		System.out.println(answer);

	}

	static void makeWord(int selIdx) {
		// 몇번째로 만들어지는 카운트
		cnt++;

		// 현재 만들어진 단어는 무엇?
		String str = "";
		for (int i = 0; i < 5; i++) {
			str += sel[i] + "";
		}

		// 공백 있다면 공백 제거해주기
		str = str.trim();

		// 그것이 찾고자 하는 단어와 같은가?
		if (str.equals(target)) {
			System.out.println(str);
			answer = cnt - 1;
			return;
		}

		// 5자리 모두 만들었으면
		if (selIdx >= 5)
			return;

		// 단어를 만들어보자
		for (int i = 0; i < 5; i++) {
			sel[selIdx] = vowels[i];
			makeWord(selIdx + 1);
			sel[selIdx] = '\u0000';
		}
	}
}
