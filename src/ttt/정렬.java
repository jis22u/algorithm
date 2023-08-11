package ttt;

import java.util.Arrays;

public class 정렬 {

//  * 두 숫자의 결합 결과를 비교하여 정렬 *
    public static void main(String[] args) {
        String[] arr = {"10", "2", "54", "6"};
        
        // 오름차순 [10, 2, 54, 6]
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        // 내림차순 [6, 54, 2, 10]
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        System.out.println(Arrays.toString(arr));
    }


//    * 일반적으로 알던 내림차순, 오름차순 정렬 *
//    public static void main(String[] args) {
//        Integer[] arr = {10, 2, 54, 6};
//
//        오름차순
//        Arrays.sort(arr, (o1, o2) -> {
//            return (o1).compareTo(o2);
//        });
//        Arrays.sort(arr);
//
//        내림차순
//        Arrays.sort(arr, (o1, o2) -> {
//            return (o2).compareTo(o1);
//        });
//        Arrays.sort(arr, Collections.reverseOrder());
//
//        System.out.println(Arrays.toString(arr));
//    }
}
