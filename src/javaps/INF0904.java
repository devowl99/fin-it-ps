package javaps;

import java.io.*;
import java.util.*;

public class INF0904 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M, D;
    static int total;

    static class Session implements Comparable<Session> {
        int day;
        int money;

        Session(int day, int money){
            this.day = day;
            this.money = money;
        }

        @Override
        public int compareTo(Session o){
            return o.day - this.day; // day 내림차순
        }
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        List<Session> sLst = new ArrayList<>();
        int maxDay = 0;
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            maxDay = Math.max(maxDay, d);

            sLst.add(new Session(d, m));
        }

        Collections.sort(sLst); // 마감 여유있는 순으로 정렬

        total = 0;
        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=maxDay; i>=1; i--){
            for (; j<N; j++){
                if (sLst.get(j).day < i) break;

                pq.offer(sLst.get(j).money);
            }

            if (!pq.isEmpty()){
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}
