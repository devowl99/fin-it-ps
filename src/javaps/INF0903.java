package javaps;

import java.io.*;
import java.util.*;

public class INF0903 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static class Event implements Comparable<Event> {
        int time;
        char event;

        Event(int time, char event){
            this.time = time;
            this.event = event;
        }

        @Override
        public int compareTo(Event o){
            if (this.time == o.time) return o.event - this.event; // 'l' -> 'a' 순 정렬
            return this.time - o.time; // 1순위) 시간 빠른 순
        }
    }

    static List<Event> eLst;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        eLst = new ArrayList<>();
        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            eLst.add(new Event(a, 'a'));

            int l = Integer.parseInt(st.nextToken());
            eLst.add(new Event(l, 'l'));
        }

        Collections.sort(eLst);

        int maxCount = 0;
        int count = 0;
        for(Event e: eLst) {
            if (e.event == 'a') count++;
            else if (e.event == 'l') count--;

            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
