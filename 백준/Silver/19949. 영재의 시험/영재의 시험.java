import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] answer, yjanswer;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = new int[10];
        for(int i=0; i<10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        yjanswer = new int[10];
        makeAnswer( 0);
        System.out.println(cnt);
    }

    static void makeAnswer (int idx) {
        if(idx == 10) {
            int sum = 0;
            for(int i=0; i<10; i++) {
                if(yjanswer[i] == answer[i]) sum++;
            }
            if(sum >= 5) { cnt++; }
            return;
        }

        for(int i=1; i<=5; i++) {
            if(idx>1 && yjanswer[idx-1] == i && yjanswer[idx-2] == i) continue;
            yjanswer[idx] = i;
            makeAnswer(idx+1);
        }
    }
}