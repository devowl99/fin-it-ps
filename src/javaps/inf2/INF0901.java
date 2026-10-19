package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0901 {

    static class People implements Comparable<People> {
        int h, w;

        People(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(People o) {
            if (this.h==o.h) return Integer.compare(this.w, o.w);
            return Integer.compare(this.h, o.h);
        }
    }

    static int N;
    static People[] pArr;

    static int solution() {
        Arrays.sort(pArr);

        int count = 1;
        for (int i=0; i<pArr.length-1; i++) {
            boolean flag = true;
            for (int j=i+1; j<pArr.length; j++) {
                if (pArr[i].w < pArr[j].w) {
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        pArr = new People[N];
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            pArr[n] = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution());
    }
}
