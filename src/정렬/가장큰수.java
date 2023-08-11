package 정렬;

import java.util.Arrays;

public class 가장큰수 {
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }


        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{ 6, 10, 2, 54}));
    }
}
