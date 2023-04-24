package Map;

import java.util.*;

public class 영어끝말잇기 {

	public static void main(String[] args) {
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] answer = {0,0};       // answer 초기화
        String front = words[0];    // 앞사람이 말한 단어
        String rear = "";           // 뒤사람이 말한 단어
        int idx = 0;                // 탈락이 발생한 사람의 번호
        Map<String, Integer> map = new HashMap<>();         // 해당 단어와 말한 사람의 번호 저장
        map.put(words[0], 1);                               // 첫번째 단어 일단 저장
        
        for(int i=1; i<words.length; i++) {
            // 해당 단어 찾을건데 존재하지 않으면 -1
            if(map.getOrDefault(words[i], -1) != -1) {
                // -1이 아니면 해당 단어 이미 존재
                answer[0] = (i%n)+1;
                answer[1] = (i/n) + 1;
                break;
            }
            
            // 중복되지 않았으면 map 에 저장
            map.put(words[i], (i%n)+1);
            rear = words[i];
        
            // 앞단어의 끝문자와 뒷단어의 앞문자가 같지 않으면
            if(front.charAt(front.length() -1) != rear.charAt(0)) {
                answer[0] = map.get(rear);
                answer[1] = (i/n) +1;
                break;
            }
            
            // 앞단어 업데이트
            front = rear;
        }
        
        for(int a : answer) {
        	System.out.println(a);
        }
	}

}
