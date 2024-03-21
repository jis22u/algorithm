import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum= 0;
		int minus=100;
		int ans = 0;
		
		for(int i=0; i<10; i++) {
			sum += Integer.parseInt(br.readLine());

			if(minus >= Math.abs(sum-100)) {
				minus = Math.abs(sum-100);
				ans = sum;
			}
		
		}
		
		System.out.println(ans);
		

	} // main

}