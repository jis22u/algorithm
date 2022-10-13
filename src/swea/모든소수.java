package swea;

// swea 3131. 100만 이하의 모든 소수
public class 모든소수 {

	public static void main(String[] args) {
		boolean[] prime = new boolean[1000001];
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i=2; i<1000001; i++) {
			if(!prime[i]) {
				for(int j=i*2; j<1000001; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<1000001; i++) {
			if(!prime[i]) {
				sb.append(i+" ");
			}
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb.toString());
		
	} // main

}
