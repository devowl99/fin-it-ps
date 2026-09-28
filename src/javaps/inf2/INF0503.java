package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0503 {

    static int solution(int N, int M, int[][] board, int[] moves) {
        Queue<Integer>[] queues = new ArrayDeque[N+1];
        for (int n=1; n<=N; n++) {
            queues[n] = new ArrayDeque<>();
        }

        for (int x=0; x<N; x++) {
            for (int y=0; y<N; y++) {
                if (board[y][x] != 0) {
                    queues[x+1].offer(board[y][x]);
                }
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int doll;
        int count = 0;
        for (int move: moves) {
            if (!queues[move].isEmpty()) {
                doll = queues[move].poll();

                if (stack.isEmpty()) {
                    stack.push(doll);
                }
                else {
                    if (stack.peek() == doll) {
                        stack.pop();
                        count+=2;
                    }
                    else {
                        stack.push(doll);
                    }
                }
            }
        }

        return count;
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
