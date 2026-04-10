package javaps;

import java.io.*;
import java.util.*;

public class INF0714v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] adjList;
    static int[] dis;
    static Queue<Integer> q;
    static StringBuilder sb;

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
        dis = new int[N+1];
        Arrays.fill(dis, -1);
        bfs();

        for (int n=2; n<=N; n++){
            sb.append(n).append(" : ").append(dis[n]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(){
        q = new ArrayDeque<>();

        dis[1] = 0;
        q.offer(1);

        while (!q.isEmpty()){
            int cur = q.poll();

            for (int n: adjList[cur]){
                if (dis[n] != -1) continue;

                dis[n] = dis[cur]+1;
                q.offer(n);
            }
        }
    }
}
