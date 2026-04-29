package javaps;

import java.io.*;
import java.util.*;

public class INF0908v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E;

    static class Node implements Comparable<Node>{
        int to;
        int cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for (int i=0; i<=V; i++){
            graph[i] = new ArrayList<>();
        }

        for (int e=0; e<E; e++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }

        visited = new boolean[V+1];
        PriorityQueue<Node> pQ = new PriorityQueue<>();

        pQ.offer(new Node(1, 0));

        int count = 0;
        int totalCost = 0;
        while (!pQ.isEmpty()){
            Node cur = pQ.poll();

            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            totalCost += cur.cost;
            count++;

            if (count == V) break;

            for (Node next: graph[cur.to]){
                if (visited[next.to]) continue;

                pQ.offer(next);
            }

        }

        System.out.println(totalCost);
    }
}
