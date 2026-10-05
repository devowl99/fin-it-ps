package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0806 {

    static int N, M;
    static int[] arr;

    static int[] perm;
    static boolean[] visited;

    static void dfs(int depth) {
        if (depth==M) {
            for (int p: perm) {
                System.out.print(p+" ");
            }
            System.out.println();

            return;
        }

        for (int n=0; n<N; n++) {
            if (visited[n]) continue;

            visited[n] = true;
            perm[depth] = arr[n];
            dfs(depth+1);
            visited[n] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        perm = new int[M];
        dfs(0);
    }
}
