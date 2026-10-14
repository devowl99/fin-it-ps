package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0813 {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};

    static int solution() {
        int count = 0;

        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                if (map[y][x]==0) continue;
                if (visited[y][x]) continue;

                visited[y][x] = true;
                dfs(x, y);
                count++;
            }
        }

        return count;
    }

    static void dfs(int x, int y) {
        for (int d=0; d<8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if (map[ny][nx]==0) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(nx, ny);
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
