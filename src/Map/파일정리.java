package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 파일정리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] exe = new String[N][2];
		Map<String, Integer> map = new HashMap<>();
		
		// 확장자 뽑아내기
		// 카운트
		for(int i=0; i<N; i++) {
			exe[i] = br.readLine().split("\\.");
			map.put(exe[i][1], map.getOrDefault(exe[i][1], 0) + 1);
		}
		
		// 사전순으로 정렬
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		for(String str:list) {
			System.out.println(str + " " + map.get(str));
		}
	}

}
