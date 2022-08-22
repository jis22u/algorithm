package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


// 영식이와 친구들
public class baek1592 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] p = new int[N];

		int ans = 0, i = 0;
		++p[0];
		// 배열 범위를 넘어설 때
		// 시계(오른쪽) 방향일 경우: (i + L) % N
		//					 L만큼 움직이고 배열 크기로 나누어준다.
		// 반시계(왼쪽) 방향일 경우: (i + N - L) % N
		//					   '배열 크기만큼 더해주고 뺀다'
		while (p[i] != M) {
			if (p[i] % 2 == 1) {
				++p[(i + L) % N];
				i = (i + L) % N;
			} else if (p[i] % 2 == 0) {
				++p[(i + N - L) % N];
				i = (i + N - L) % N;
			}
			ans++;
		}

		// bw.write 의 반환값은 String형이므로 int형 정수를 출력하고 싶을 때는
		// 아래와 같은 방법으로 Stirng으로 형변환해주어야 한다.
		// 아예 실행 코드내에서 String으로 형변환해주고 bw.write에 넣어줄 수도 있다.
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	} // main

}
