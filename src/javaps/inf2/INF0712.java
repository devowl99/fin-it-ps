package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0712 {

    static int count;
    static boolean[] visited;

    static void dfs(boolean[][] graph, int N, int M, int from) {

        if (from == N) {
            count++;
            return;
        }

        visited[from] = true;

        for (int to=1; to<=N; to++){
            if (!graph[from][to]) continue;
            if (visited[to]) continue;

            dfs(graph, N, M, to);
        }

        visited[from] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[N+1][N+1];
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = true;
        }

        count = 0;
        visited = new boolean[N+1];
        dfs(graph, N, M, 1);
        System.out.println(count);
    }
}
