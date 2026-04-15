package javaps;

import java.io.*;
import java.util.*;

public class INF0807 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, R;
    static int[][] comb;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        comb = new int[N+1][R+1];
        for (int[] c: comb) Arrays.fill(c, -1);

        System.out.println(dfs(N, R));
    }

    static int dfs(int n, int r){
        if (n == r || r == 0) return 1;

        if (comb[n][r] != -1) return comb[n][r];

//      comb[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
//      return comb[n][r]
        return comb[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }
}
