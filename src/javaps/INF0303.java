package javaps;

import java.io.*;
import java.util.*;

public class INF0303 {
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
        int p1 = 0;
        int p2 = K;
        int total;
        while (p2 <= N){
            total = 0;
            for (int i=p1; i<p2; i++){
                total += record[i];
            }
            totalMax = Math.max(totalMax, total);
            p1++;
            p2++;
        }

        System.out.println(totalMax);
    }
}
