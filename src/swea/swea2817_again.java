package swea;

public class swea2817_again {
	static int N;
	static boolean[] check;
	public static void main(String[] args) {

	}
	
	
	static void powerSet(int idx) {
		if(idx == N) {
			return;
		}
		
		check[idx] = true;
		powerSet(idx+1);
	}

}
