package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0807v3 {

    static int[][] C;

    static int dfs(int n, int r) {
        if (r==0) return 1;
        if (n==r) return 1;

        if (C[n][r]!=0) return C[n][r];

        return C[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        C = new int[n+1][r+1];
        System.out.println(dfs(n, r));
    }
}
