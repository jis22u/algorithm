package 문자열;

import java.util.*;


public class 개인정보 {

	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		// 약관 정보 저장
        int[] termsData = new int[26];
        for(int i=0; i<terms.length; i++) {
            String[] data = terms[i].split(" ");
            termsData[data[0].charAt(0) - 'A'] = Integer.parseInt(data[1]);
        }

        List<Integer> list = new ArrayList<>();

        // 개인정보
        for(int i=0; i<privacies.length; i++) {
            String[] data = privacies[i].split(" ");
            String date = data[0];
            String type = data[1];

            // true 이면, 파기
            if(search(today, date, termsData[type.charAt(0) - 'A'])){
                // System.out.println(i+1);
                list.add(i+1);
            }
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

	}
	
	static boolean search(String today, String date, int term) {
        String[] todayDate = today.replace(".", "/").split("/");
        String[] privacyDate = date.replace(".", "/").split("/");

        // 유효기간 끝나는 날 구하기
        int YYYY = Integer.parseInt(privacyDate[0]);
        int MM = Integer.parseInt(privacyDate[1])+term;
        while(MM > 12) {
            YYYY++;
            MM = MM-12;
        }

        int DD = Integer.parseInt(privacyDate[2]) - 1;
        if(DD == 0) {
            DD = 28;
            MM--;
        }

        // 오늘자 기준으로 파기여부 판단
        if(YYYY>Integer.parseInt(todayDate[0])) {
            return false;
        } else if(YYYY == Integer.parseInt(todayDate[0])){
            if(MM>Integer.parseInt(todayDate[1])) {
                return false;
            } else if (MM == Integer.parseInt(todayDate[1])) {
                if(DD>=Integer.parseInt(todayDate[2])) {
                    return false;
                }
            }
        } 
        return true;

    }

}
