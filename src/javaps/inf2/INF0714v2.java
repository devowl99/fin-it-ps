package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0714v2 {

    static class Node implements Comparable<Node> {
        int n;
        int l;

        Node (int n, int l) {
            this.n = n;
            this.l = l;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.n, o.n);
        }
    }

    static int N, M;

    static List<Integer>[] graph;
    static boolean[] visited;
    static List<Node> nodeList;

    static void solution() {
        nodeList = new ArrayList<>();

        Queue<Node> q = new ArrayDeque<>();
        visited = new boolean[N+1];

        visited[1] = true;
        q.offer(new Node(1, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int x: graph[cur.n]) {
                if (visited[x]) continue;

                visited[x] = true;

                Node newNode = new Node(x, cur.l+1);
                q.offer(newNode);
                nodeList.add(newNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int n=1; n<=N; n++) {
            graph[n] = new ArrayList<>();
        }

        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
        }

        solution();
        Collections.sort(nodeList);
        StringBuilder sb = new StringBuilder();
        for(Node n: nodeList) {
            sb.append(n.n).append(" : ").append(n.l).append("\n");
        }

        System.out.println(sb.toString());
    }
}
