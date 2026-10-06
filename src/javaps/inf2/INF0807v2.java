package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0807v2 {

    static int n, r;
    static int[][] C;

    static int dfs(int N, int R) {
        if (N==R || R==0) return C[N][R] = 1;

        if (C[N][R] != 0) return C[N][R];

        return C[N][R] = dfs(N-1, R-1) + dfs(N-1, R);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        C = new int[n+1][r+1];

        System.out.println(dfs(n, r));
    }
}
