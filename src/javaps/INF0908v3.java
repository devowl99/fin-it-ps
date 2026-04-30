package javaps;

import java.io.*;
import java.util.*;

public class INF0908v3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E;

    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int v = 0; v <= V; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        int answer = prim();

        System.out.println(answer);
    }

    static int prim() {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        int count = 0;
        int totalCost = 0;

        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge cur = pQ.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            count++;
            totalCost += cur.cost;

            if (count == V) break; // 최적화 용도

            for (Edge next: graph[cur.to]) {
                if (visited[next.to]) continue; // 이미 방문한 노드로의 간선은 저장 X (최적화 용도)
                pQ.offer(next);
            }
        }

        return totalCost;
    }
}
