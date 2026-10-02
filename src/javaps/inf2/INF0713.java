package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0713 {

    static int N, M;
    static int count;
    static List<Integer>[] graph;
    static boolean[] visited;

    static int solution(List<Integer>[] adjLst) {
        count = 0;

        graph = adjLst;
        visited = new boolean[N+1];

        visited[1] = true;
        dfs(1);

        return count;
    }

    static void dfs(int node) {
        if (node == N) {
            count++;
            return;
        }

        for (int x: graph[node]) {
            if (visited[x]) continue;

            visited[x] = true;
            dfs(x);
            visited[x] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] adjLst = new ArrayList[N+1];
        for (int n=1; n<=N; n++){
            adjLst[n] = new ArrayList<>();
        }

        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjLst[from].add(to);
        }

        System.out.println(solution(adjLst));
    }
}
