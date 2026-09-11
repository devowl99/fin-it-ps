package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0212 {

    static int solution(int N, int M, int[][] board) {
        // N : 학생 수
        // M : 수학테스트 횟수

        int count = 0;
        for (int mento=1; mento<=N; mento++) {
            for (int menti=1; menti<=N; menti++) {
                if (mento == menti) continue;

                int mentoRank = 0;
                int mentiRank = 0;
                boolean match = true;

                for (int test=1; test<=M; test++) {
                    for (int rank=1; rank<=N; rank++) {
                        if (board[test][rank] == mento) mentoRank = rank;
                        else if (board[test][rank] == menti) mentiRank = rank;
                    }

                    if (mentoRank > mentiRank) match = false;
                }

                if (match) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[M+1][N+1];
        for (int m=1; m<=M; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n=1; n<=N; n++) {
                board[m][n] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(N, M, board));
    }
}
