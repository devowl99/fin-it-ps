package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0714 {

    static class Node {
        int n;
        int m;

        Node (int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static List<Integer>[] graph;
    static boolean[] visited;

    static String solution(int N, int M) {
        Queue<Node> q;
        StringBuilder sb = new StringBuilder();

        for (int goal=2; goal<=N; goal++) {
            q = new ArrayDeque<>();
            visited = new boolean[N+1];

            visited[1] = true;
            q.offer(new Node(1, 0));

            while(!q.isEmpty()) {
                Node node = q.poll();

                if (node.n==goal) {
                    sb.append(goal).append(" : ").append(node.m).append("\n");
                    break;
                }

                for (int n: graph[node.n]) {
                    if (visited[n]) continue;

                    visited[n] = true;
                    q.offer(new Node(n, node.m+1));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        System.out.println(solution(N, M));
    }
}
