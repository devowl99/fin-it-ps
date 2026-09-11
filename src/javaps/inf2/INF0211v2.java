package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0211v2 {

    static int solution(int N, int[][] board) {

        int maxCount = -1;
        int president = 0;

        for (int s1=1; s1<=N; s1++) {
            int count = 0;

            for (int s2=1; s2<=N; s2++) {
                if (s1==s2) continue;

                for (int grade=1; grade<=5; grade++) {
                    if (board[s1][grade] == board[s2][grade]) {
                        count++;
                        break;
                    }
                }
            }

            if (maxCount < count) {
                maxCount = count;
                president = s1;
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
