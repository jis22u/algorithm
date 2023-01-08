package 문자열;

// 배열 이용해서 원소마다 다 돌리니까 시간초과 남 ㅜㅜ
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가희와키워드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 메모장 입력 받고
		String[] memo = new String[N];
		for(int i=0; i<N; i++) {
			memo[i] = br.readLine();
		}
		// 글에 쓰인 단어 T/F 체크할거야
		boolean[] check = new boolean[N];
		
		// 쓰인 단어는 T처리해주자
		// 동시에 안쓰인 단어 F 개수 카운트해줄거야
		int cnt = 0;
		
		for(int i=0; i<M; i++) {
			String[] str = br.readLine().split(",");
			for(int j=0; j<str.length; j++) {
				// 사용된 키워드 찾아내기
				for(int k=0; k<N; k++) {
					if(str[j].equals(memo[k])) {
						check[k] = true;
						break;
					}
				}
			}

			// 사용 안 된 키워드 개수 찾기
			for(int j=0; j<N; j++) {
				if(!check[j]) {
					cnt++;
				}
			}
			System.out.println(cnt);
			
			// 개수 초기화
			cnt = 0;
		}
	} //main

}
