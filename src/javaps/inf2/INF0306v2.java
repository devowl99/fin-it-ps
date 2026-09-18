package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0306v2 {

    static int solution(int n, int k, int[] a) {

        int zeroCount = 0;
        int maxLen = 0;
        int lt = 0;
        for (int rt=0; rt<n; rt++) {
            if (a[rt] == 0) zeroCount++;

            while (zeroCount > k) {
                if (a[lt] == 0) {
                    zeroCount--;
                }
                lt++;
            }

            maxLen = Math.max(maxLen, rt-lt+1);
        }

        return maxLen;
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
