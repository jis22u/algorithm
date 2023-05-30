package TreeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeMap;

// TreeMap 활용해서 풀이
public class 파일정리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> extension = new TreeMap<>();								// 기본 정렬(오름차순)
//		TreeMap<String, Integer> extension = new TreeMap<>(Comparator.naturalOrder());		// 오름차순
//		TreeMap<String, Integer> extension = new TreeMap<>(Comparator.reverseOrder());  	// 내림차순

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			String[] fileName = br.readLine().split("\\.");
			extension.put(fileName[1], extension.getOrDefault(fileName[1], 0) + 1);
		}

		for(String key : extension.keySet()){
			System.out.println(key + " " + extension.get(key));
		}
		
		
		// ------------ TreeMap 활용해보기 ------------
		System.out.println(extension.firstEntry()); //최소 Entry
		System.out.println(extension.firstKey());   //최소 Key
		System.out.println(extension.lastEntry());  //최대 Entry
		System.out.println(extension.lastKey());    //최대 Key
	}
}
