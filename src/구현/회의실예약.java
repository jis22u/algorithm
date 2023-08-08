package 구현;

import java.util.*;
import java.io.*;


public class 회의실예약
{
    static List<int[]> list;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 키: 회의실 이름, 값: 회의실 예약 현황
        Map<String, boolean[]> meeting = new HashMap<>();
        for(int i=0; i<N; i++) {
            meeting.put(br.readLine(), new boolean[9]);
        }
        // 회의실 이름을 기준으로 정렬해야 하므로
        List<String> keyList = new ArrayList<>(meeting.keySet());
        keyList.sort((s1,s2) -> s1.compareTo(s2));

        // 주어진 입력값 대로 회의실 예약 현황 체크
        boolean[] reservation;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            reservation = meeting.get(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j=s; j<t; j++) {
                reservation[j-9] = true;
            }
        }

        // 이제 이용 가능한 회의실 시간대 조사해보자
        for(int i=0; i<keyList.size(); i++) {
            String r = keyList.get(i);
            System.out.printf("Room %s:\n", r);
            reservation = meeting.get(r);

            isAvailable(reservation);
            if(list.size() == 0) {
                System.out.println("Not available");
            } else {
                System.out.printf("%d available:\n", list.size());
                for(int[] a : list) {
                    System.out.printf("%02d-%02d\n", a[0], a[1]);
                }
            }
            if(i != keyList.size()-1) {
                System.out.println("-----");
            }
        }

    }

    // 이용 가능한 회의실 시간대 탐색 메서드
    static void isAvailable(boolean[] reservation) {
        list = new ArrayList<>();
        int s = 0;
        int t = 0;
        for(int i=0; i<9; i++) {
            if(!reservation[i]) {
                s = i;
                for(int j=i; j<9; j++) {
                    if(reservation[j]) {
                        t = j;
                        break;
                    } else if(j==8 && !reservation[8]) {
                        reservation[8] = true;
                        t = j+1;
                    } else {
                        reservation[j] = true;
                    }
                }
                int[] arr = new int[2];
                arr[0] = s+9;
                arr[1] = t+9;
                list.add(arr);
            }
        }
    }
}