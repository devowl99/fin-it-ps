package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0811 {

    static class Point {
        int x, y;
        int count;

        Point (int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int N=7;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int solution() {
        Queue<Point> q = new ArrayDeque<>();

        visited[1][1] = true;
        q.offer(new Point(1, 1, 0));

        while(!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x==N && cur.y==N) {
                return cur.count;
            }

            for (int d=0; d<4; d++) {
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];

                if (nx<1 || nx>N || ny<1 || ny>N) continue;
                if (board[ny][nx]==1) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new Point(nx, ny, cur.count+1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}
