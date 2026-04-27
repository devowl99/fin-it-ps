package javaps;

import java.io.*;
import java.util.*;

// 최소 스패닝 트리 - 프림
// 혼자 고민한 로직
public class INF0908 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E;

    static class Node implements Comparable<Node>{
        int v;
        int cost;

        Node(int v, int cost){
            this.v = v;
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
        for (int i=1; i<=V; i++){
            graph[i] = new ArrayList<>();
        }

        for (int e=0; e<E; e++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        visited = new boolean[V+1];


        int next = 1;
        int count = 1;
        int totalCost = 0;
        while(count != V){
            visited[next] = true;

            for (Node n: graph[next]){
                pQ.offer(n);
            }

            while(!pQ.isEmpty()){
                Node cur = pQ.poll();
                if (visited[cur.v]) continue;

                next = cur.v;
                visited[cur.v] = true;
                totalCost += cur.cost;
                count++;
                break;
            }
        }

        System.out.println(totalCost);
    }
}
