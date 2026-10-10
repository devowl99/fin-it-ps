package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0809 {

    static int N, M;
    static int[] comb;

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int x: comb) {
                System.out.print(x+" ");
            }
            System.out.println();

            return;
        }

        for (int i=start; i<=N; i++) {
            comb[depth] = i;
            dfs(depth+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb = new int[M];
        dfs(0, 1);
    }
}
