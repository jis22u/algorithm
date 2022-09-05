package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek3040 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9];
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int sum=0;
		out:
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				for(int k=j+1; k<9; k++) {
					for(int l=k+1; l<9; l++) {
						for(int m=l+1; m<9; m++) {
							for(int n=m+1; n<9; n++) {
								for(int o=n+1; o<9; o++) {
									sum = arr[i] + arr[j] + arr[k] + arr[l] + arr[m] + arr[n] + arr[o];
									if(sum == 100) {
										System.out.print(arr[i] +"\n" + arr[j] + "\n" +arr[k] + "\n" +arr[l] + "\n" +arr[m] + "\n" +arr[n] + "\n" +arr[o]);
										break out;
									}
								}
							}
						}
					}
				}
			}
		}
		
		//0 1 2 3 4 5 6 
		// 
		
	} //main

}
