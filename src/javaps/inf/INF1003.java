package javaps.inf;

import java.io.*;
import java.util.*;

public class INF1003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] dp; // i번째 수를 마지막으로 하는 최대 증가 수열 길이
    static int maxNum;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for (int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1];
        dp[1] = 1;
        maxNum = 0;
        for (int i=2; i<=N; i++){
            dp[i] = 1;

            for (int j=1; j<i; j++){
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            maxNum = Math.max(maxNum, dp[i]);
        }

        System.out.println(maxNum);
    }
}
