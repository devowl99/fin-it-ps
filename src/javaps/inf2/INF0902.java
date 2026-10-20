package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0902 {

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end); // 끝 시각이 빠른 순
        }
    }

    static List<Meeting> mLst;

    static int solution(int N) {
        Collections.sort(mLst);

        int count = 0;
        int lastEnd = 0;
        for (Meeting m: mLst) {
            if (m.start >= lastEnd) {
                count++;
                lastEnd = m.end;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        mLst = new ArrayList<>();
        StringTokenizer st;
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            mLst.add(new Meeting(s, e));
        }

        System.out.println(solution(N));
    }
}
