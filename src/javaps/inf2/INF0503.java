package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0503 {

    static int solution(int N, int M, int[][] board, int[] moves) {

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        StringTokenizer st;
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m=0; m<N; m++) {
                board[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int M = Integer.parseInt(br.readLine());

        int[] moves = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, board, moves));
    }
}
