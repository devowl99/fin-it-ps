package javaps;

import java.io.*;
import java.util.*;

public class INF0813 {
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
        // 0:바다, 1:섬
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (visited[i][j] || map[i][j] == 0) continue;

                dfs(new Point(j, i));
                count++;
            }
        }

        System.out.println(count);

    }

    static void dfs(Point p) {
        int x = p.x;
        int y = p.y;

        visited[y][x] = true;

        for (int d=0; d<8; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx<0 || N<=nx || ny<0 || N<=ny) continue;
            if (visited[ny][nx] || map[ny][nx] == 0) continue;

            dfs(new Point(nx, ny));
        }
    }
}
