package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0301 {

    static String solution(int N, int M, int[] arr1, int[] arr2) {

        int[] ansArr = new int[N+M];
        int n, m;
        n = m = 0;
        int left = 0;
        for (int i=0; i<N+M; i++) {
            if (n==N) {
                left = 2;
                break;
            }
            else if (m==M) {
                left = 1;
                break;
            }

            if (arr1[n] < arr2[m]) {
                ansArr[n+m] = arr1[n++];
            }
            else if (arr1[n] > arr2[m]) {
                ansArr[n+m] = arr2[m++];
            }
            else {
                ansArr[n+m] = arr1[n++];
                ansArr[n+m] = arr2[m++];
            }
        }

        if (left == 1) {
            for (; n<N; n++) {
                ansArr[n+m] = arr1[n];
            }
        }
        else if (left == 2) {
            for (; m<M; m++) {
                ansArr[n+m] = arr2[m];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x: ansArr) {
            sb.append(x).append(' ');
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, arr1, arr2));

    }
}
