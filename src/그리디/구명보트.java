package 그리디;

import java.util.Arrays;

// 다른 사람 풀이 : 가장 작은 값과도 같이 타지 못하면 반드시 혼자 타게 된다. 
public class 구명보트 {

	public static void main(String[] args) {
		int[] people = {70,50,80,50};
		//50, 50, 70, 80
		int limit = 100;
		
		Arrays.sort(people);
        int len = people.length;
        int boat = 0;
        int left = 0;
        int right = len - 1;
        
		while (left <= right) {
			int sum = people[left] + people[right];
			if (sum > limit) {
				right--;
				boat++;
			} else {
				right--;
				left++;
				boat++;
			}
		}
        
        int answer = boat;
        System.out.println(answer);
	}

}

// 이전 풀이
// Arrays.sort(people);
// int len = people.length;
// boolean[] save = new boolean[len];
// int boat = 0;
// int left = 0;
// int right = len - 1;
// for(int i=0; i<len; i++) {
//     if(save[i]) continue;
//     left = i;
//     boat++;
//     while(left < right) {
//        if(save[right]) {
//             right--;
//             continue;
//        }
//        int sum = people[left] + people[right];
//        if(sum > limit) {
//            right--;
//        } else {
//            save[left] = true;
//            save[right] = true;
//            break;
//        }
//     }
//     save[i] = true;
// }
//
// int answer = boat;
// return answer;
