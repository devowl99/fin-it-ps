package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0303 {

    static int solution(int n, int k, int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        for (int p=0; p<n-k; p++) {
            int sum = 0;
            for (int i=0; i<k; i++) {
                sum += arr[p+i];
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }
}
