package javaps;

import java.io.*;
import java.util.*;

public class INF0814 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};

    static class Point {
        int x, y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        // 1이면 섬임
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (visited[i][j] || map[i][j] == 0) continue;

                bfs(j, i);
                count++;
            }
        }

        System.out.println(count);

    }

    static void bfs(int x, int y){
        Queue<Point> q = new ArrayDeque<>();

        visited[y][x] = true;
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d=0; d<8; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if (visited[ny][nx] || map[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }
}
