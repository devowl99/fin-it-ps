package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0904 {

    static class Request implements Comparable<Request> {
        int money;
        int day;

        Request(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Request o) {
            return Integer.compare(o.day, this.day); // day 기준 내림차순 정렬 (높은순)
        }
    }

    static int N;
    static List<Request> rLst;

    static int solution() {
        Collections.sort(rLst);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int maxDay = rLst.get(0).day;
        int totalMax = 0;
        int j = 0;
        for (int i=maxDay; i>=1; i--) {
            for (; j<rLst.size(); j++) {
                if (rLst.get(j).day < i) break;

                pq.offer(rLst.get(j).money);
            }

            if (!pq.isEmpty()) {
                totalMax += pq.poll();
            }
        }

        return totalMax;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        rLst = new ArrayList<>();
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            rLst.add(new Request(m, d));
        }

        System.out.println(solution());
    }
}
