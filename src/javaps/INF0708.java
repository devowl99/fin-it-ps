package javaps;

import java.io.*;
import java.util.*;

public class INF0708 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int S, E;
    static Queue<Point> q;
    static boolean[] visited;
    static int[] skip = {1, 5, -1};

    static class Point {
        int loc;
        int jump;

        Point (int loc, int jump) {
            this.loc = loc;
            this.jump = jump;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 현수의 위치
        E = Integer.parseInt(st.nextToken()); // 송아지의 위치

        // 앞으로 1, 뒤로 1, 앞으로 5
        // 최소 점프 구하기
        visited = new boolean[10001];
        System.out.println(bfs());

    }

    static int bfs() {
        q = new ArrayDeque<>();
        q.offer(new Point(S, 0));
        visited[S] = true;

        while (!q.isEmpty()){
            Point p = q.poll();

            if (p.loc == E) return p.jump;

            for (int s: skip){
                int next = p.loc + s;

                if (1 <= next && next <= 10000){
                    if (visited[next]) continue;

                    q.offer(new Point(next, p.jump+1));
                    visited[next] = true;
                }
            }
        }

        return -1;
    }
}
