package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0812 {

    static class Tomato {
        int x, y;
        int day;

        Tomato (int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int N, M;
    static int[][] box;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int solution() {
        // 1: 익은 토마토 0: 안 익은 토마토 -1: 토마토 없음
        Queue<Tomato> q = new ArrayDeque<>();

        int not = 0;
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                if (box[y][x] == 1) q.offer(new Tomato(x, y, 0));
                else if (box[y][x] == 0) not++; // 안 익은 토마토 수
            }
        }

        if (!q.isEmpty() && not == 0) return 0;

        int leastDay = 0;
        while (!q.isEmpty()) {
            Tomato tmt = q.poll();

            if (leastDay < tmt.day) leastDay = tmt.day;

            for (int d=0; d<4; d++) {
                int nx = tmt.x + dx[d];
                int ny = tmt.y + dy[d];

                if (nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if (box[ny][nx] != 0) continue;

                box[ny][nx] = 1;
                not--;
                q.offer(new Tomato(nx, ny, tmt.day+1));
            }
        }

        if (not != 0) return -1;
        else return leastDay;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

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
