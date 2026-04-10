package javaps;

import java.io.*;
import java.util.*;

public class INF0713 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i=1; i<=N; i++) adjList[i] = new ArrayList<>();

        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        count = 0;
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1);

        System.out.println(count);
    }

    static void dfs(int node) {
        if (node == N){
            count++;
            return;
        }

        for (int n: adjList[node]){
            if (visited[n]) continue;

            visited[n] = true;
            dfs(n);
            visited[n] = false;
        }
    }
}
