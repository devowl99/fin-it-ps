package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0903 {

    static class Friend implements Comparable<Friend> {
        int time;
        char stat;

        Friend(int time, char stat) {
            this.time = time;
            this.stat = stat;
        }

        @Override
        public int compareTo(Friend o) {
            if (this.time==o.time) {
                return Integer.compare(o.stat, this.stat);
            }
            return Integer.compare(this.time, o.time);
        }
    }

    static int N;
    static List<Friend> fLst;

    static int solution() {
        Collections.sort(fLst);

        int maxNum = 0;
        int curNum = 0;

        for(Friend f: fLst) {
            if (f.stat == 'a') curNum++;
            else if (f.stat == 'l') curNum--;

            maxNum = Math.max(maxNum, curNum);
        }

        return maxNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        fLst = new ArrayList<>();

        StringTokenizer st;
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            fLst.add(new Friend(a, 'a'));
            fLst.add(new Friend(l, 'l'));
        }

        System.out.println(solution());
    }
}
