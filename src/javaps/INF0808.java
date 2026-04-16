package javaps;

import java.io.*;
import java.util.*;

public class INF0808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, F;
    static int[] perm;
    static int[][] C;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        C = new int[N][N];
        for (int i=0; i<N; i++) comb(N-1, i);

        flag = false;
        perm = new int[N];
        visited = new boolean[N+1];
        dfs(0, 0);
    }

    static int comb(int n, int r){
        if (C[n][r] != 0) return C[n][r];
        if (r==0 || n==r) return C[n][r] = 1;

        return C[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }

    static void dfs(int depth, int sum){
        if (flag) return;

        if (depth == N){
            if (sum == F) {
                for (int x: perm) System.out.print(x+" ");
                flag = true;
            }
            return;
        }

        for (int i=1; i<=N; i++){
            if (visited[i]) continue;

            perm[depth] = i;
            visited[i] = true;
            dfs(depth+1, sum + (i * C[N-1][depth]));
            visited[i] = false;
        }
    }
}
