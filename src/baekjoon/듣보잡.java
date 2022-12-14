package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 듣보잡 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 듣도 못한 사람
		int N = sc.nextInt();
		String[] arrN = new String[N];
		// 보도 못한 사람
		int M = sc.nextInt();
		
		// 일단 듣도 못한 사람들을 set에 넣어준다
		Set<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(sc.next());
		}
		
		// 이후에 보도 못한 사람이 set의 값들과 중복되면 cnt++
		int cnt = 0;
		// 듣도 보도 못한 사람들을 list에 저장한다.
		List<String> list = new ArrayList<>();
		
		// 보도 못한 사람들을 입력받으면서 검사한다
		for(int i=0; i<M; i++) {
			String str = sc.next();
			if(set.contains(str)) {
				cnt++;
				list.add(str);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(cnt);
		for(String str : list) {
			System.out.println(str);
		}
	} // main

}
