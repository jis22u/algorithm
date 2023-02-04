package DFS;

public class 단어변환 {
	static int len, min;
    static boolean[] visited;
    static String[] words;
    static String target;
	public static void main(String[] args) {
		String begin = "hit";
		target = "cog";
		words = new String[]{"hot","dot","dog","lot","log", "cog"};
		min = Integer.MAX_VALUE;
        // words 배열 길이
        len = words.length;
        // 방문처리
        visited = new boolean[len];
        
        // 0인덱스부터 len-1 인덱스까지 모두 검사해보자
        for(int i=0; i<len; i++) {
            // 단어 한 개만 다르다면
            if(ckeckDifOne(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], 1, i); // ㄱㄱㄱ
                visited[i] = false;
            }
        }
        
        int answer = min;
        if(answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
	}
	
	// begin: 비교 단어, cnt: 단계, idx: 현재 인덱스
    static void dfs(String begin, int cnt, int idx) {
//        if(idx >= len-1) return;
    	if(begin.equals(target)) {
//    		System.out.println(min);
            min = Math.min(cnt, min);
            return;
        } 
        
        for(int i=0; i<len; i++) {
            if(visited[i]) continue;
            
            if(ckeckDifOne(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], cnt+1, i);
                visited[i] = false;
            }
        }
    }
    
    static boolean ckeckDifOne(String begin, String word) {
        int lenC = begin.length();
        int cnt = 0;
        for(int i=0; i<lenC; i++) {
            if(begin.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        
        if(cnt == 1) { return true;} 
        else { return false; }
    }
}
