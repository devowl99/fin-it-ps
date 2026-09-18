package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0306 {

    static int solution(int n, int k, int[] a) {
        // k : 0을 1로 k번까지 변경 가능
        int chance = k;
        int maxLen = 0;
        int len = 0;
        int lt = 0;
        for (int rt=0; rt<n; rt++) {
            len++;

            if (a[rt] == 0) { // 0인 경우
                if (chance != 0) chance--; // 찬스 있으면 소모

                else { // 찬스 없으면
                    while (a[lt] == 1) {
                        lt++;
                        len--;
                    }

                    lt++;
                    len--;
                }
            }

            maxLen = Math.max(maxLen, len);
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
