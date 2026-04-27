package javaps;

import java.io.*;
import java.util.*;

// 최소 스패닝 트리 - 크루스칼
public class INF0907 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E;

    static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int cost;

        Edge(int u, int v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<Edge> edgeList;
    static int[] p;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();

        for (int e=0; e<E; e++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(u, v, cost));
        }

        Collections.sort(edgeList);

        make();

        int count = 0;
        int totalCost = 0;
        for (Edge e: edgeList){
            if (union(e.u, e.v)){ // 연결 안되어있어서 연결해줌
                totalCost += e.cost;
                count++;
            }

            if (count == V-1) break;
        }

        System.out.println(totalCost);
    }

    static void make(){
        p = new int[V+1];
        for (int v=0; v<=V; v++){
            p[v] = v;
        }
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        p[rootX] = rootY;
        return true;
    }

    static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }
}
