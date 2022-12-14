package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 1931
public class 회의실배정 {
	
	// 회의 하나(I)를 정의
	static class Meeting implements Comparable<Meeting> {
		// 시작 시간과 끝시간
		int stT, edT;
		
		public Meeting(int stT, int edT) {
			this.stT = stT;
			this.edT = edT;
		}
		
		// 우선순위큐를 활용하기 위해 기준 정해주기
		// 끝나는 시간이 가장 빠른 순서대로 정렬
		@Override
		public int compareTo(Meeting o) {
			// 종료시간이 같을 경우 시작시간을 기준으로 정렬
			// 시작시관과 종료시간이 같은 회의가 있는 경우 때문에
			// 반례 (1,3) (3,4) (4,4)
			if(this.edT == o.edT) {
				return this.stT - o.stT;
			}
			return this.edT - o.edT;
		}
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * <최대한 많이 배정하기 위한 조건>
		 * 끝나는 시간이 가장 빠른 순서대로 배정
		 * <풀이>
		 * 1. 우선순위큐에 끝나는 시간을 기준으로 회의들을 정렬하여 저장
		 * 2. 끝나는 시간이 가장 빠른 회의이면서(pq에서 이미 처리)
		 * 3. 다음 시작시간으로 유효하면 PQ에서 뽑기 
		 * 4. 2,3번 pq가 빌 때까지 반복
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 회의의 수
		int N = Integer.parseInt(br.readLine());
		// 입력받을 모든 회의 저장할 큐
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		
		// 1. N개 회의를 저장해보자
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int stT = Integer.parseInt(st.nextToken());
			int edT = Integer.parseInt(st.nextToken());
			pq.add(new Meeting(stT, edT));
		}
		
		// 2,3. 조건에 적합한 회의 배정
		// 배정한 회의 개수
		int cnt = 0;
		// 이전 회의 끝시간 저장
		int pastEd = 0;
		
		while(!pq.isEmpty()) {
			Meeting m = pq.poll();
			int nSt = m.stT;
			int nEd = m.edT;
			
			if(nSt < pastEd) continue;
			
			pastEd = nEd;
			cnt++;
		}
		
		// 정답 출력
		System.out.println(cnt);
		
	} // main
	

}
