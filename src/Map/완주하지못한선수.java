package Map;

import java.util.*;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		// 선수이름 - 선수 수 저장할 Map
        HashMap<String, Integer> map = new HashMap<>();
        // 참가자 목록 저장
        for(String player_name : participant) {
            // HashMap.getOrDefault('A', 0) : key(A)에 해당하는 value 있으면 가져오고
            // 없으면 Default로 지정한 0 가져오기
            map.put(player_name, map.getOrDefault(player_name,0) + 1);
        }
        
        // 경쟁자 추려내기
        for(String player_name : completion) {
            // map.get(Key) : key에 해당하는 value 가져오기
            // 해당 이름의 선수 카운트 계산해주기
            map.put(player_name, map.get(player_name) - 1);          
        }
        
        // Map.Entry<> : key-value 형태의 한 쌍을 Entry라고 함
        // map.entrySet() : Entry 다 가져오기
        // map.keySet() : key 다 가져오기
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        
        String answer = "";
        
        // iter.hasNext() : 다음 요소에 읽어 올 요소가 있으면 true, 없으면 false
        while(iter.hasNext()) {
            // iter.next() : 다음 요소 가져오기
            Map.Entry<String, Integer> entry = iter.next();
            // 선수 명수가 0이 아닌 경우, 즉 완주하지 못한 선수이면
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        System.out.println(answer);
	}

}
