package Trie;


// 다음엔 더 깊게 이해해보자..
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
	/*
	 * 1. 트리형태인 trie(트라이) 자료구조를 이용한다.
	 * 	  트라이의 각 노드는 class로 정의한다. (변수명 Node)
	 * 2. Map Interface를 이용한다.
	 *    Map의 키 값에는 문자를 이루는 각 단어가 들어가고, 
	 *    키와 매핑되는 값에는 자식 노드 클래스가 저장된다.
	 * 3. 단어의 끝인지 아닌지를 체크하는 boolean 변수를 이용한다.
	 * 
	 * 기타. rootNode는 앞글자의 문자가 바뀌면 새로 갱신된다.   (??)
	 */
	
	// 트라이 자료구조의 각 노드
	static class Node {
		// 자식노드
		Map<Character, Node> childNode = new HashMap<>();
		// 단어의 끝인지 아닌지 체크
		boolean isEnd;
	}
	
	// 루트노드
	static Node rootNode;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			// 입력받은 정수 N개만큼 전화번호를 words 배열에 저장한다.
			int N = Integer.parseInt(br.readLine());
			String[] words = new String[N];
			for(int i=0; i<N; i++) {
				words[i] = br.readLine();
			}
			
			// 동일한 루트노드들끼리 검색해야하므로
			// 문자열 정렬을 이용한다. (가 가나 가나다 나다 나다라)
			Arrays.sort(words);
			
			// 루트노드는 한번만 생성하고 필요에 따라 갱신
			rootNode = new Node();
			// 결과값 ans
			String ans = "YES";
			
			for(int i=0; i<N; i++) {
				// 트라이에 단어들을 저장해보자
				// 근데 반환값이 false라면
				if(!insert(words[i])) {
					ans = "NO";
					break;
				}
			}
			
			System.out.println(ans);
		} 
	} // main
	
	// 중간에 다른 숫자를 접두어로 가지고 있다는 것이 발견되면 false 반환
	// 중간에 걸리지않고 주륵 저장된다면 true 반환
	static boolean insert(String num) {
		// 일단 루트노드 가져와봐
		Node thisNode = rootNode;
		
		// 해당 문자열의 각 단어(num.charAt(i))를 키 값으로 가지는 value가 존재하는지 체크
		for(int i=0; i<num.length(); i++) {
			// num.charAt(i)는 Map(childNode)의 key로 작동
			char c = num.charAt(i);
			
			// 해당 문자가 없으면 (자식)노드를 새로 만든다
			if(thisNode.childNode.get(c) == null) {
				thisNode.childNode.put(c, new Node());
			}
			
			// 자식노드로 이동
			thisNode = thisNode.childNode.get(c);
			
			// 근데 thisNode가 마지막 노드라면 접두어를 가지고 있다는 뜻
			if(thisNode.isEnd) {
				return false;
			}
		}
		// 마지막 노드는 문자의 끝이라고 체크해주기
		thisNode.isEnd = true;
		
		// 중간에 걸리지 않고 잘 저장되었다면 일관성 있는 전화번호목록
		return true;
	}

}
