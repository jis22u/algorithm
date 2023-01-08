package 문자열;

// 이번엔 set 자료구조 이용
// map 자료구조 이용하는게 좀 더 빠르네..?
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가희와키워드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 메모장 입력 받고
		// Set에 저장
		Set<String> memo = new HashSet<>();
		for(int i=0; i<N; i++) {
			memo.add(br.readLine());
		}
		
		// set 자료구조 이용
		int cnt = 0;
		for(int i=0; i<M; i++) {
			String[] str = br.readLine().split(",");
			for(int j=0; j<str.length; j++) {
				if(memo.contains(str[j])) {
					memo.remove(str[j]);
				}
			}
			cnt = memo.size();
			System.out.println(cnt);
		}
	} //main

}
