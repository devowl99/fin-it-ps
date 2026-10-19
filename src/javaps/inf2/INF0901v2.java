package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0901v2 {

    static class People implements Comparable<People> {
        int h, w;

        People(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(People o) {
            return Integer.compare(o.h, this.h);
        }
    }

    static int N;
    static List<People> pLst;

    static int solution() {
        Collections.sort(pLst);

        int count = 0;
        int maxW = 0;

        for (People p: pLst) {
            if (p.w > maxW) {
                count++;
                maxW = p.w;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pLst = new ArrayList<>();
        StringTokenizer st;
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());

            pLst.add(new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(solution());
    }
}