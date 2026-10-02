package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0708 {

    static class Point {
        int cnt;
        int loc;

        Point(int cnt, int loc) {
            this.cnt = cnt;
            this.loc = loc;
        }
    }

    static int[] jump = {1, -1, 5};

    static int solution(int S, int E) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10001];

        q.offer(new Point(0, S));
        visited[S] = true;

        int answer = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();

            if (p.loc == E) {
                answer = p.cnt;
                break;
            }

            for (int i=0; i<3; i++) {
                int next = p.loc + jump[i];

                if (next<1 || next>10000) continue;
                if (visited[next]) continue;

                visited[next] = true;
                q.offer(new Point(p.cnt+1, next));
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(solution(S, E));
    }
}
