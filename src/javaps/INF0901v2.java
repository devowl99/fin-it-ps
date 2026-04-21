package javaps;

import java.io.*;
import java.util.*;

public class INF0901v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static class People implements Comparable<People> {
        int h, w;

        People(int h, int w){
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(People o){
            return o.h - this.h; // 내림차순
        }
    }

    static List<People> pLst;
    static int count;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        pLst = new ArrayList<>();
        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pLst.add(new People(h, w));
        }

        Collections.sort(pLst);
        int maxW = 0;
        count = 0;

        for (People p: pLst){
            if (p.w > maxW) {
                count++;
                maxW = p.w;
            }
        }

        System.out.println(count);
    }
}
