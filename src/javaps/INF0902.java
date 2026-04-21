package javaps;

import java.io.*;
import java.util.*;

public class INF0902 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o){
            if (this.end == o.end) return this.start - o.start; // 2순위) 시작 시간 이른 순 (오름차순)
            return this.end - o.end; // 1순위) 끝나는 시간 이른 순 (오름차순)
        }
    }

    static List<Meeting> meetingList;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        meetingList = new ArrayList<>();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            meetingList.add(new Meeting(s, e));
        }

        Collections.sort(meetingList);
        int endTime = 0;
        int count = 0;
        for (Meeting m: meetingList){
            if (m.start >= endTime) {
                count++;
                endTime = m.end;
            }
        }

        System.out.println(count);
    }
}
