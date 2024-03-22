import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
	
		//최고 학년 수 구하기
		int max =0;
		//학생 정보 배열 생성		
		int[][] students = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, students[i][1]);
			}
		}
		
		//방 배정
		//row 학년, col 성별
		int[][] room = new int[max+1][2];
		for(int i=0; i<N; i++) {
			if(students[i][0]==0)
				room[students[i][1]][0]++;
			else if(students[i][0]==1)
				room[students[i][1]][1]++;
		}
		
		//방 개수 카운트
		int over=0;
		int cnt=0;
		for(int i=1; i<max+1; i++) {
			for(int j=0; j<2; j++) {
				if(room[i][j] != 0 && room[i][j]<= K) {
					cnt++;
				} else if(room[i][j]>K) {
					if(room[i][j]%K!=0) {
						over += ((room[i][j]/K)+1);
					} else if(room[i][j]%K==0){
						over += (room[i][j]/K);
					}
				}
				
			}
		}
		
		System.out.println(over+cnt);
	} //main

}
