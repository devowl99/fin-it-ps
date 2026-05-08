package javaps;

import java.io.*;
import java.util.*;

public class INF1003v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] dp;
    static int maxNum;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        if (input == null) return;
        N = Integer.parseInt(input);

        arr = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        maxNum = 0;
        for (int i=1; i<=N; i++){
            int max = 0;
            for (int j=i-1; j>=0; j--){
                if (arr[j] < arr[i] && dp[j] > max) max = dp[j];
            }
            dp[i] = max+1;
            maxNum = Math.max(maxNum, dp[i]);
        }

        System.out.println(maxNum);
    }
}
