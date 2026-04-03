package javaps;

import java.io.*;
import java.util.*;

public class INF0209 {
    static int N;
    static int[][] board;
    static StringTokenizer st;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum1;
        int sum2;
//        // 1. 가로
//        for (int row=0; row<N; row++){
//            sum = 0;
//            for (int x: board[row])
//                sum += x;
//            maxSum = Math.max(maxSum, sum);
//        }
//
//        // 2. 세로
//        for (int col=0; col<N; col++){
//            sum = 0;
//            for (int row=0; row<N; row++){
//                sum += board[row][col];
//            }
//            maxSum = Math.max(maxSum, sum);
//        }

        // 가로/세로 통합
        for (int i=0; i<N; i++){
            sum1 = sum2 = 0;
            for (int j=0; j<N; j++){
                // i 고정, j 탐색
                sum1 += board[i][j];
                sum2 += board[j][i];
            }
            maxSum = Math.max(maxSum, Math.max(sum1, sum2));
        }

        // 대각선
        sum1 = sum2 = 0;
        for (int i=0; i<N; i++){
            sum1 += board[i][i];
            sum2 += board[N-i-1][i];
        }
        maxSum = Math.max(maxSum, Math.max(sum1, sum2));

        System.out.println(maxSum);
    }
}
