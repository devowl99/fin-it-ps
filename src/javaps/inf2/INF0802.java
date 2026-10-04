package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0802 {

    static int C, N;
    static int[] dogs;
    static int maxW;

    static void solution(int c, int n, int[] arr) {
        C=c;
        N=n;
        dogs=arr;

        maxW = 0;
        int sumW = 0;
        subset(sumW, 0);
    }

    static void subset(int sumW, int i) {

        if (i==N) {
            maxW = Math.max(maxW, sumW);
            return;
        }

        if (sumW+dogs[i] <= C) {
            subset(sumW+dogs[i], i+1); // 선택하는 경우
        }
        subset(sumW, i+1); // 선택 안하는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution(c, n, arr);
        System.out.println(maxW);
    }
}
