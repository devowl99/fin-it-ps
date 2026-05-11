package javaps;

import java.io.*;
import java.util.*;

public class INF1005v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] coins;

    static int[] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        coins = new int[N];
        for (int i=0; i<N; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        dp = new int[M+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin: coins) {
            for (int i=coin; i<=M; i++){
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        System.out.println(dp[M]);
    }
}
