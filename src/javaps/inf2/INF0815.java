package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0815 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;

    static List<Point> hs;
    static List<Point> pz;

    static Point[] pComb;

    static int totalMinDis;

    static int solution() {
        // 피자집 M 개만 생존
        // 0: 빈칸 1: 집 2: 피자집
        hs = new ArrayList<>();
        pz = new ArrayList<>();

        for (int y=1; y<=N; y++) {
            for (int x=1; x<=N; x++) {
                if (map[y][x]==1) hs.add(new Point(x, y));
                else if (map[y][x]==2) pz.add(new Point(x, y));
            }
        }

        pComb = new Point[M];
        totalMinDis = Integer.MAX_VALUE;
        dfs(0, 0); // 조합

        return totalMinDis;
    }

    static void dfs(int depth, int start) {
        if (depth==M) {
            calc();
            return;
        }

        for (int i=start; i<pz.size(); i++) {
            pComb[depth] = pz.get(i);
            dfs(depth+1, i+1);
        }
    }

    static void calc() {
        int totalDis = 0;

        for (Point h: hs) {
            int dis = Integer.MAX_VALUE;

            for (Point p: pComb) {
                dis = Math.min(dis, Math.abs(h.x-p.x)+Math.abs(h.y-p.y));
            }

            totalDis += dis;
        }

        totalMinDis = Math.min(totalMinDis, totalDis);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}
