package javaps;

import java.io.*;
import java.util.*;

public class INF0811 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int N = 7;

    static Queue<Point> q;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point {
        int x, y, cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
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

        System.out.println(bfs());
    }

    static int bfs(){
        q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()){
            Point p = q.poll();

            if (p.x == N-1 && p.y == N-1) {
                return p.cnt;
            }

            for (int d=0; d<4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if (map[ny][nx] == 1) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new Point(nx, ny, p.cnt+1));
            }
        }

        return -1;
    }
}
