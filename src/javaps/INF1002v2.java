package javaps;

import java.io.*;
import java.util.*;

public class INF1002v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static int[] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=N+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N+1]);
    }
}
