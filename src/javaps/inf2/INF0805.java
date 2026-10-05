package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0805 {

    static int n, change;
    static int[] coins;

    static int minCount;

    static void solution(int N, int M, int[] arr) {
        n=N;
        change=M;
        coins=arr;

        Arrays.sort(coins);
        minCount = Integer.MAX_VALUE;
        dfs(0, 0);
    }

    static void dfs(int sum, int coinCount) {
        if (sum>change) return;
        if (coinCount>=minCount) return;

        if (sum==change) {
            minCount = coinCount;
            return;
        }

        for (int i=n-1; i>=0; i--) {
            dfs(sum+coins[i], coinCount+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        solution(N, M, arr);
        System.out.println(minCount);
    }
}
