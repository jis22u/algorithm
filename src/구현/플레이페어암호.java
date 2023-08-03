package 구현;

import java.util.*;
import java.io.*;


public class 플레이페어암호
{

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        String key = br.readLine();

        // step1. 키판 만들기
        makeKeyBoard(key);

        // step2. 메세지 두 단어로 만들기
        doDivide(msg);

        // step3. 쌍을 이룬 두 글자로 암호화하기
        String ans = doEncrypt();
        
        // 정답 출력
        System.out.println(ans);
    }

    static char[][] keyBoard;       // 5x5판에 키 표현
    static void makeKeyBoard(String key) {
        boolean[] alpabet = new boolean[26];
        alpabet[9] = true;          // J 빼고
        keyBoard = new char[5][5];

        int r = 0;
        int c = 0;
        while(r<5 && c<5) {
            // 키 문자열 채우기
            for(int i=0; i<key.length(); i++) {
                if(alpabet[key.charAt(i)-65]) continue;
                keyBoard[r][c] = key.charAt(i);
                alpabet[key.charAt(i)-65] = true;

                if(c<4) { c++; }
                else { r++; c=0; }
            }

            // 나머지 알파벳 채우기
            for(int i=0; i<26; i++) {
                if(alpabet[i]) continue;
                keyBoard[r][c] = (char)(i+65);
                alpabet[i] = true;

                if(c<4) { c++; }
                else { r++; c=0; }
            }
        }
    }

    static ArrayList<String> list;      // 두 글자씩 나눈거 저장
    static void doDivide(String msg) {
        list = new ArrayList<>();
        int len = list.size();
        String str = "";
        for(int i=0; i<msg.length(); i+=2) {
            if(i+2 < msg.length()) {
                str = msg.substring(i, i+2);
            } else {
                str = msg.substring(i, msg.length());
            }
            list.add(str);

            // 두 개 문자 같은거 발견
            len = list.size();
            StringBuilder strSb = new StringBuilder();
            if(str.length()==2 && str.charAt(0) == str.charAt(1)) {
                list.remove(len-1);
                if(str.charAt(0) == 'X') {
                    str = "XQ";
                } else {
                    str = strSb.append(str.charAt(0)).append('X').toString();
                }
                list.add(str);
                i = i-1;
            }
        }

        // 마지막 남은 글자 1글자라면 X 붙이기
        if(list.get(len-1).length() == 1) {
            String last = list.get(len-1)+"X";
            list.remove(len-1);
            list.add(last);
        }
    }

    static String doEncrypt() {
        StringBuilder sb = new StringBuilder();
        int len = list.size();
        int r0 = 0;
        int c0 = 0;
        int r1 = 0;
        int c1 = 0;

        for(int i=0; i<len; i++) {
            // 리스트에서 하나씩 꺼내서 0,1번째 문자 위치 확인
            String str = list.get(i);
            for(int r=0; r<5; r++) {
                for(int c=0; c<5; c++) {
                    if(keyBoard[r][c] == str.charAt(0)) {
                        r0 = r;
                        c0 = c;
                    }

                    if(keyBoard[r][c] == str.charAt(1)) {
                        r1 = r;
                        c1 = c;
                    }
                }
            }

            // 키판에 따라 암호화하기
            if(r0 == r1) {          // 같은 행에 존재
                sb.append(keyBoard[r0][(c0+1)%5]).append(keyBoard[r1][(c1+1)%5]);
            } else if(c0 == c1) {   // 같은 열에 존재
                sb.append(keyBoard[(r0+1)%5][c0]).append(keyBoard[(r1+1)%5][c1]);
            } else {                // 서로 다른 행,열에 존재
                sb.append(keyBoard[r0][c1]).append(keyBoard[r1][c0]);
            }
        }

        return sb.toString();
    }
}