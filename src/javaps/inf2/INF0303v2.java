package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0303v2 {

    static int solution(int n, int k, int[] arr) {

        int maxSum = 0;
        for (int i=0; i<k; i++) {
            maxSum += arr[i];
        }

        int sum = maxSum;
        for (int p=k; p<n; p++) {
            sum = sum-arr[p-k]+arr[p];
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
