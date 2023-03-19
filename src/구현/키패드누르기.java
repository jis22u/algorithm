package 구현;

public class 키패드누르기 {

	public static void main(String[] args) {
		
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		// 키패드 위 숫자 위치 저장
        int[][] keypad = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        // 처음 왼손, 오른손 위치 저장
        int[] cur_left = {3,0};
        int[] cur_right = {3,2};
        // 정답 저장
        String[] answers = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            // 왼쪽 키
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answers[i] = "L";
                cur_left = keypad[numbers[i]];
            } 
            // 오른쪽 키
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answers[i] = "R";
                cur_right = keypad[numbers[i]];
            }
            // 가운데 숫자열이면
            else {
                int dist_left = Math.abs(cur_left[0] - keypad[numbers[i]][0]) + Math.abs(cur_left[1] - keypad[numbers[i]][1]);
                int dist_right = Math.abs(cur_right[0] - keypad[numbers[i]][0]) + Math.abs(cur_right[1] - keypad[numbers[i]][1]);
                // 오른손이 가까우면
                if(dist_left > dist_right) {
                    answers[i] = "R";
                    cur_right = keypad[numbers[i]];
                } 
                // 왼손이 가까우면
                else if (dist_left < dist_right) {
                    answers[i] = "L";
                    cur_left = keypad[numbers[i]];
                } 
                // 거리가 같으면
                else {
                    if(hand.equals("left")) {
                        answers[i] = "L";
                        cur_left = keypad[numbers[i]];
                    } else {
                        answers[i] = "R";
                        cur_right = keypad[numbers[i]];
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<answers.length; i++) {
            sb = sb.append(answers[i]);
        }
        String answer = sb.toString();
        System.out.println(answer);
	}

}
