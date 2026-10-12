package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0812 {

    static class Tomato {
        int x, y;
        int stat;

        Tomato (int x, int y, int stat) {
            this.x = x;
            this.y = y;
            this.stat = stat;
        }
    }

    static int N, M;
    static int[][] box;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int solution() {
        // 1: 익은 토마토 0: 안 익은 토마토 -1: 토마토 없음
        Queue<Tomato> q = new ArrayDeque<>();

        for (int n=0; n<N; n++) {
            for (int m=0; m<M; m++) {
                if (box[n][m] == 1) q.offer(new Tomato(m, n, 1));
                else if (box[n][m] == 0) q.offer(new Tomato(m, n, 0));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m=0; m<M; m++) {
                box[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}
