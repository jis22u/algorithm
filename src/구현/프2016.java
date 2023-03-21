package 구현;

public class 프2016 {

	public static void main(String[] args) {

    int a = 5;
    int b = 4;
		String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    String answer = "";
    int past = 0;         // 일 수 누적

    // 모든 월일 조회하며 타겟 요일 찾기
    for(int month = 1; month<=12; month++) {
        for(int day = 1; day<=days[month]; day++) {
              // 타겟 요일 찾으면 break
              if(a == month && b == day) {
                  answer = week[(past+7) % 7];
                  break;
              }
              past++;
         }
     }
    System.out.println(answer);
}
