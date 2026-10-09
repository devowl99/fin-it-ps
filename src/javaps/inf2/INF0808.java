package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0808 {

    static int[][] C;
    static List<Integer> list;
    static int[] perm;
    static boolean[] visited;
    static boolean flag;

    static String solution(int n, int f) {
        C = new int[n+1][n+1];
        list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            list.add(dfs(n-1, i));
        }

        visited = new boolean[n+1];
        perm = new int[n];
        perm(0, n, f);

        StringBuilder sb = new StringBuilder();
        for (int x: perm) {
            sb.append(x).append(" ");
        }

        return sb.toString().trim();
    }

    static int dfs(int n, int r) {
        if (n==r || r==0) return 1;
        if (C[n][r] != 0) return C[n][r];

        return C[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }

    static void perm(int depth, int n, int f) {

        if (flag) return;

        if (depth == n) {
            int sum=0;
            for (int i=0; i<n; i++) {
                sum += (perm[i]*list.get(i));
            }

            if (sum == f) {
                flag = true;
            }

            return;
        }

        for (int i=1; i<=n; i++) {
            if (flag) return;
            if (visited[i]) continue;

            visited[i] = true;
            perm[depth] = i;
            perm(depth+1, n, f);
            visited[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, f));
    }
}
