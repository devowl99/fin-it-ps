package javaps;

import java.io.*;
import java.util.*;

public class INF0812 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M, N;
    static int[][] box;

    static Queue<Tomato> q;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Tomato {
        int x, y, day;

        Tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int tCount;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        tCount = 0;

        q = new ArrayDeque<>();

        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            for (int m=0; m<M; m++){
                int t = Integer.parseInt(st.nextToken());
                if (t == 0) tCount++; // 안 익은 토마토 수 세기
                if (t == 1) q.offer(new Tomato(m, n, 0));
                box[n][m] = t;
            }
        }

        if (tCount == 0) System.out.println(0); // 안 익은 토마토가 없는 경우
        else System.out.println(bfs());
    }

    static int bfs(){
        int date = 0;

        while (!q.isEmpty()){
            Tomato t = q.poll();

            date = t.day;

            for (int d=0; d<4; d++){
                int nx = t.x + dx[d];
                int ny = t.y + dy[d];

                // 1 : 익음, 0 : 익지 않음, -1 : 빈 칸
                if (nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if (box[ny][nx] != 0) continue; // 안 익은 토마토 아닌 경우

                box[ny][nx] = 1;
                tCount--;
                q.offer(new Tomato(nx, ny, t.day+1));
            }
        }

        if (tCount == 0) return date;
        else return -1;
    }
}
