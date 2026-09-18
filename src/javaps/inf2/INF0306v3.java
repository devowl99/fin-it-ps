package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0306v3 {

    static int solution(int n, int k, int[] a) {


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, a));
    }
}
}
