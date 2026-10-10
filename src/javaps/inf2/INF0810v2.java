package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0810v2 {

    static class Point {
        int x, y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N=7;
    static int[][] board;
    static boolean[][] visited;
    static int answer;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int solution() {
        answer = 0;

        visited[1][1] = true;
        dfs(new Point(1, 1));

        return answer;
    }

    static void dfs(Point p) {
        if (p.x==N && p.y==N) {
            answer++;
            return;
        }

        for (int d=0; d<4; d++) {
            int nx = p.x+dx[d];
            int ny = p.y+dy[d];

            if (nx<1 || nx>N || ny<1 || ny>N) continue;
            if (visited[ny][nx]) continue;
            if (board[ny][nx]==1) continue;

            visited[ny][nx] = true;
            dfs(new Point(nx,ny));
            visited[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        visited = new boolean[N+1][N+1];
        board = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}
