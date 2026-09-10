package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0209 {

    static int solution(int N, int[][] board) {
        int maxRow = 0, maxCol = 0, maxDia;

        int sumRow;
        for (int n=0; n<N; n++) {
            sumRow = 0;
            for (int m=0; m<N; m++) {
                sumRow += board[n][m];
            }

            maxRow = Math.max(maxRow, sumRow);
        }

        int sumCol;
        for (int n=0; n<N; n++) {
            sumCol = 0;
            for (int m=0; m<N; m++) {
                sumCol += board[m][n];
            }

            maxCol = Math.max(maxCol, sumCol);
        }

        int sumDia1 = 0;
        int sumDia2 = 0;
        for (int n=0, m=0; n<N; n++, m++) {
            sumDia1 += board[n][m];
        }
        for (int n=N-1, m=0; n>=0; n--, m++) {
            sumDia2 += board[n][m];
        }
        maxDia = Math.max(sumDia1, sumDia2);

        return Math.max(maxRow, Math.max(maxCol, maxDia));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        StringTokenizer st;
        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for (int m=0; m<N; m++) {
                board[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(N, board));
    }

}
