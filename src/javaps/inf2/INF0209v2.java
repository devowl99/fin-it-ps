package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0209v2 {

    static int solution(int N, int[][] board) {
        int maxSum=0;

        int sumRow;
        int sumCol;
        for (int n=0; n<N; n++) {
            sumRow = sumCol = 0;
            for (int m=0; m<N; m++) {
                sumRow += board[n][m];
                sumCol += board[m][n];
            }
            maxSum = Math.max(maxSum, Math.max(sumRow, sumCol));
        }

        int sumDia1 = 0;
        int sumDia2 = 0;
        for (int n=0; n<N; n++) {
            sumDia1 += board[n][n];
            sumDia2 += board[N-1-n][n];
        }
        maxSum = Math.max(maxSum, Math.max(sumDia1, sumDia2));

        return maxSum;
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
