package javaps;

import java.io.*;
import java.util.*;

public class INF0712 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] matrix;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][N+1];
        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        count = 0;
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1);

        System.out.println(count);
    }

    static void dfs(int node) {
        if (node == N) {
            count++;
            return;
        }

        for (int i=1; i<=N; i++){
            if (visited[i]) continue;

            if (matrix[node][i] == 1) {
                visited[i] = true;
                dfs(i);
                visited[i] = false;
            }
        }
    }
}
