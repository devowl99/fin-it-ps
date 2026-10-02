package javaps.inf2;

import java.io.*;
import java.util.*;

// 정점 재방문 허용, 동일 방향 간선 재사용 금지 버전
public class INF0712v2 {

    static int count;
    static boolean[][] visited;

    static void dfs(boolean[][] graph, int N, int M, int from) {

        if (from == N) {
            count++;
            return;
        }

        for (int to=1; to<=N; to++){
            if (graph[from][to] && !visited[from][to]) {

                visited[from][to] = true;
                dfs(graph, N, M, to);
                visited[from][to] = false;
            }
        }
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
        visited = new boolean[N+1][N+1];
        dfs(graph, N, M, 1);
        System.out.println(count);
    }
}
