package 구현;

// 어우 나중에 다시
// 백준 12933
import java.util.Scanner;

public class 오리 {

	static char[] QUACK = {'q','u','a','c','k'};
	static int duck, remain;
	public static void main(String[] args) {
		// duck 오리수
		// quack
		
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();	
		int len = arr.length;
		sc.close();

		duck = 0; 
		// 문자열의 길이가 5의 배수가 아니면 -1
		if(arr.length%5 != 0) {
			duck = -1; 
		} else {
			isDuck(arr);
		}
		
		System.out.println(remain==0?duck:-1);
	} // main
	
	static void isDuck(char[] arr) {
		remain = arr.length;
		
		while(remain != 0) {
			int pick = 0;
            int idx = 0;
            boolean chk = false;
            int[] tmp = new int[5];

            // tmp에 정상 quack의 인덱스 저장
            while (idx < arr.length) {
                if (arr[idx]==QUACK[pick]) {
                    tmp[pick++] = idx;
                    if (pick==5) {
                        chk = true;
                        remain-=5;
                        pick=0;
                        for (int i = 0; i < 5; i++) arr[tmp[i]] = '\0';
                    }
                }
                idx++;
            }
            if (chk) duck++;
            else break;
        }
	}
}
