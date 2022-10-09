package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


// TreeSet = HashSet과 마찬가지로 Set인터페이스를 구현한 클래스로써
//			 중복 허용하지 않으며, 저장 순서도 유지되지 않는다. (HashSet과 동일)
//			 이진탐색트리 구조를 가지며, 값추가시 기본적으로 오름차순으로 정렬된다.  
//			 검색과 정렬에 유리하다.
//			 노드의 추가, 삭제에는 시간이 걸린다.

// swea5948. 새샘이
public class TreeSet활용 {
	static int[] arr, selected;
	static TreeSet<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			arr = new int[7];
			selected = new int[3];
			set = new TreeSet<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combi(0,0);
			
			for(int i=1; i<5; i++) {
				set.remove(set.last());
			}
			System.out.println("#"+t+" "+set.last());
			
//			Iterator<Integer> iter = set.iterator();
//			while(iter.hasNext()) {
//				System.out.println(iter.next());
//			}
			
//			for(int a : set) {
//				System.out.print(a+" ");
//			}
		}
	} // main
	
	static void combi(int idx, int sidx) {
		if(sidx == 3) {
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum += selected[i];
			}
			set.add(sum);
			return;
		}
		if(idx == 7) return;
		
		selected[sidx] = arr[idx];
		combi(idx+1, sidx+1);
		combi(idx+1, sidx);
	}
}
