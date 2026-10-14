package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0814 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};

    static int solution() {
        int count = 0;

        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                if (map[y][x]==0 || visited[y][x]) continue;

                bfs(new Point(x, y));
                count++;
            }
        }

        return count;
    }

    static void bfs(Point p) {
        Queue<Point> q = new ArrayDeque<>();
        visited[p.y][p.x] = true;
        q.offer(p);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d=0; d<8; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if (map[ny][nx]==0 || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}
