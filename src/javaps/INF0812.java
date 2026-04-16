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
        int x, y;

        Tomato(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int tCount;
    static int emp;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        tCount = 0;
        emp = 0;
        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            for (int m=0; m<M; m++){
                int t = Integer.parseInt(st.nextToken());
                if (t == 0) tCount++;
                else if (t == -1) emp++;
                box[n][m] = t;
            }
        }

        if (tCount+emp == N*M) System.out.println(0);
        else System.out.println(bfs());
    }

    static int bfs(){
        int date = 0;

        q = new ArrayDeque<>();

        for (int y=0; y<N; y++){
            for (int x=0; x<M; x++){
                if (box[y][x] == 1) q.offer(new Tomato(x, y));
            }
        }

        while (!q.isEmpty()){
            Tomato t = q.poll();

            date = Math.max(date, box[t.y][t.x]);

            for (int d=0; d<4; d++){
                int nx = t.x + dx[d];
                int ny = t.y + dy[d];

                // 1 : 익음, 0 : 익지 않음, -1 : 빈 칸
                if (nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if (box[ny][nx] != 0) continue;

                box[ny][nx] = box[t.y][t.x] + 1;
                tCount--;
                q.offer(new Tomato(nx, ny));
            }
        }

        if (tCount == 0) return date-1;
        else return -1;
    }
}
