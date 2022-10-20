import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		while(true) {
			sb = new StringBuilder();
			String tmp = sc.nextLine();
			if(tmp.equals("END")) break;
			
			StringBuilder rts = sb.append(tmp);
			StringBuilder str = rts.reverse();
			
			System.out.println(str.toString());
		}
	}

}