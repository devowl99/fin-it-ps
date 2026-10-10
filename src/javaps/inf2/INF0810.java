package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0810 {

    static int N=7;
    static int[][] board;
    static boolean[][] visited;
    static int answer;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int solution() {
        answer = 0;
        visited[1][1] = true;
        dfs(1, 1);

        return answer;
    }

    static void dfs(int x, int y) {
        if (x==N && y==N) {
            answer++;
            return;
        }

        for (int d=0; d<4; d++) {
            int nx = x+dx[d];
            int ny = y+dy[d];

            if (1>nx || N<nx || 1>ny || N<ny) continue;
            if (visited[ny][nx]) continue;
            if (board[ny][nx]==1) continue;

            visited[ny][nx] = true;
            dfs(nx, ny);
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
