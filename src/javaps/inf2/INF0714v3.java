package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0714v3 {

    static int N, M;
    static List<Integer>[] graph;
    static int[] dist; // visited 겸 거리 저장

    static void solution() {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next: graph[cur]) {
                if (dist[next]!=-1) continue;

                dist[next] = dist[cur]+1;
                q.offer(next);
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

        dist = new int[N+1];
        Arrays.fill(dist, -1);

        solution();

        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=N; i++) {
            sb.append(i).append(" : ").append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }
}
