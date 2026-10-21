package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0903 {

    static class Friend implements Comparable<Friend> {
        int arrive;
        int leave;

        Friend(int arrive, int leave) {
            this.arrive = arrive;
            this.leave = leave;
        }

        @Override
        public int compareTo(Friend o) {
            if (this.arrive==o.arrive) return Integer.compare(this.leave, o.leave);
            return Integer.compare(this.arrive, o.arrive);
        }
    }

    static int N;
    static List<Friend> fLst;

    static int solution() {
        Collections.sort(fLst);

        List<Integer> lst = new ArrayList<>();
        for (Friend f: fLst) {
            if (lst)
        }
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
            fLst.add(new Friend(a, l));
        }

        System.out.println(solution());
    }
}
