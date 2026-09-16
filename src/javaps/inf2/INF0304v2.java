package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0304v2 {

    static int solution(int n, int m, int[] arr) {

        int count = 0;
        int lt = 0;
        int sum = 0;
        for (int rt=0; rt<n; rt++) {
            sum += arr[rt];

            while (sum > m) {
                sum -= arr[lt++];
            }

            if (sum == m) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));
    }

}
