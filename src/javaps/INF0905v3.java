package javaps;

import java.io.*;
import java.util.*;

public class INF0905v3 {
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

    static List<Node>[] nList;
    static int[] dis;
    static final int INF = Integer.MAX_VALUE;
    static int start = 1;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nList = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            nList[i] = new ArrayList<>();
        }
        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nList[from].add(new Node(to, cost));
        }

        dij();

        for (int i=2; i<=N; i++){
            if (dis[i] != INF) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }
    }

    static void dij() {
        PriorityQueue<Node> pQ = new PriorityQueue<>();

        dis = new int[N+1];
        Arrays.fill(dis, INF);

        dis[start] = 0;
        pQ.offer(new Node(start, 0));

        while (!pQ.isEmpty()){
            Node cur = pQ.poll();

            int curTo = cur.to;
            int curCost = cur.cost;

            if (curCost > dis[curTo]) continue;
            for (Node next: nList[curTo]){
                if (dis[next.to] > dis[curTo] + next.cost){
                    dis[next.to] = dis[curTo] + next.cost;
                    pQ.offer(new Node(next.to, dis[next.to]));
                }
            }
        }
    }
}
