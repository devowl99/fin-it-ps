package javaps;

import java.io.*;
import java.util.*;

public class INF0905v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    static List<Node>[] graph;
    static int[] dis;
    static final int INF = Integer.MAX_VALUE;
    static int start;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int n=1; n<=N; n++){
            graph[n] = new ArrayList<>();
        }

        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        start = 1;
        dij();

        for (int i=2; i<=N; i++){
            if (dis[i] != INF) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }
    }

    static void dij() {
        dis = new int[N+1];
        Arrays.fill(dis, INF);
        dis[start] = 0;

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));

        while (!pQ.isEmpty()){
            Node cur = pQ.poll();
            int curNode = cur.to;
            int curCost = cur.cost;

            // 뽑은 값이 dis에 저장된 최솟값보다 클 때
            if (curCost > dis[curNode]) continue;

            // 나하고 연결된 것 중
            for (Node next: graph[curNode]){
                int nextNode = next.to;
                int nextCost = next.cost;

                // dis에 저장된 최소 cost <= 현재 노드까지 cost + 현재->다음 노드 cost
                if (dis[nextNode] > dis[curNode] + nextCost) {
                    dis[nextNode] = dis[curNode] + nextCost;
                    pQ.offer(new Node(nextNode, dis[nextNode]));
                }
            }
        }
    }
}
