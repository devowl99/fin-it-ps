package javaps;

import java.io.*;
import java.util.*;

public class INF0810 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int N = 7;
    static int count;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 출발점 0, 0
        // 도착점 6, 6
        count = 0;
        dfs(new Point(0, 0));

        System.out.println(count);
    }

    static void dfs(Point p) {

        visited[p.y][p.x] = true;

        if (p.y == N-1 && p.x == N-1){
            count++;
            visited[p.y][p.x] = false;
            return;
        }

        for (int d=0; d<4; d++){
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];

            if (nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if (map[ny][nx] == 1) continue;
            if (visited[ny][nx]) continue;

            dfs(new Point(nx, ny));
        }

        visited[p.y][p.x] = false;
    }
}
