package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0210 {

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int solution(int N, int[][] board) {

        int count = 0;
        for (int y=1; y<N+1; y++) {
            for (int x=1; x<N+1; x++) {
                boolean higher = true;

                for (int d=0; d<4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (board[ny][nx] >= board[y][x]) {
                        higher = false;
                        break;
                    }
                }

                if (higher) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N+2][N+2];

        StringTokenizer st;
        for (int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<N+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(N, board));
    }
}
