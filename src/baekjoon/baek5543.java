package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek5543 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] burger = new int[3];
		int[] beverage = new int[2];
		
		for(int i=0; i<3; i++) {
			burger[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<2; i++) {
			beverage[i] = Integer.parseInt(br.readLine());
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				int sum = burger[i] + beverage[j] -50;
				if(min > sum) {
					min = sum;
				}
			}
		}
		
		System.out.println(min);
	} //main

}
