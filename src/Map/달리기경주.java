package Map;

import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {

	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		
		// 선수 랭킹 저장 배열, 인덱스가 랭킹
		String[] answer = new String[players.length];
		// Map에 선수이름, 등수 저장
		Map<String, Integer> rank = new HashMap<>();
		for(int i=0; i<players.length; i++) {
		    rank.put(players[i], i);
		    answer[i] = players[i];      
		}

		int order = 0;       // 추월한 선수의 원래 등수
		String front = "";   // 추월한 선수의 이름 변수
		String rear = "";    // 추월 당한 선수 이름 변수
		for(int i=0; i<callings.length; i++) {
		    // 추월한 선수의 등수 찾기
		    order = rank.get(callings[i]);
		    // 해당 선수들 이름
		    front = answer[order];
		    rear = answer[order-1];

		    // 선수들 등수 갱신
		    // 1) Map: map 성질을 활용하여 .put() 으로 갱신
		    rank.put(front, order-1);
		    rank.put(rear, order);

		    // 2) answer 배열에도 적용
		    answer[order-1] = front;
		    answer[order] = rear;
		}

		for(String player : answer) {
			System.out.println(player);
		}
	}
}
