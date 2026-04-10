package javaps;

import java.io.*;
import java.util.*;

public class INF0714 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static Queue<Node> q;
    static StringBuilder sb;

    static class Node {
        int node;
        int level;

        Node (int node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i=1; i<=N; i++) adjList[i] = new ArrayList<>();

        int from;
        int to;
        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
        }

        sb = new StringBuilder();
        for (int i=2; i<=N; i++){
            visited = new boolean[N+1];
            visited[1] = true;
            bfs(i);
        }

        System.out.println(sb);
    }

    static void bfs(int goal){
        q = new ArrayDeque<>();
        q.offer(new Node(1, 0));

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (cur.node == goal) {
                sb.append(goal).append(" : ").append(cur.level).append("\n");
                return;
            }

            for (int n: adjList[cur.node]){
                if (visited[n]) continue;

                visited[n] = true;
                q.offer(new Node(n, cur.level+1));
            }
        }
    }
}
