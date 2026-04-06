package javaps;

import java.io.*;
import java.util.*;

public class INF0303v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] record;
    static int totalMax;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        record = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            record[i] = Integer.parseInt(st.nextToken());
        }

        totalMax = 0;
        for (int i=0; i<K; i++){
            totalMax += record[i];
        }

        int total = totalMax;
        for (int i=K; i<N; i++){
            total = total + record[i] - record[i-K];
            totalMax = Math.max(totalMax, total);
        }
//        int p1 = 0;
//        int p2 = K;
//        for (int i=p1; i<p2; i++){
//            totalMax += record[i];
//        }
//
//        int total = totalMax;
//        while (p2 < N){
//            total = total - (record[p1++]) + (record[p2++]);
//            totalMax = Math.max(totalMax, total);
//        }

        System.out.println(totalMax);
    }
}
