package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0211 {

    static int solution(int N, int[][] board) {

        int[][] matrix = new int[N+1][N+1];

        for (int grade=1; grade<=5; grade++) {
            for (int s1=1; s1<N; s1++) {
                int cls = board[s1][grade];

                for (int s2=s1+1; s2<=N; s2++) {
                    if (board[s2][grade] == cls && matrix[s1][s2]==0) {
                        matrix[s1][s2] = matrix[s2][s1] = 1;
                    }
                }
            }
        }

        int president = 0;
        int maxMeet = -1;
        for (int i=1; i<=N; i++) {
            int meet = 0;

            for (int j=1; j<=N; j++) {
                meet += matrix[i][j];
            }

            if (meet > maxMeet) {
                maxMeet = meet;
                president = i;
            }
        }

        return president;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N+1][5+1];
        StringTokenizer st;
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(N, board));
    }
}
