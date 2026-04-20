package javaps;

import java.io.*;
import java.util.*;

public class INF0815 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N; // 지도 크기
    static int M; // 살리고자 하는 피자집
    static int[][] map;

    static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> house;
    static List<Point> pizza;
    static List<Point> savePizza;

    static int minDis = Integer.MAX_VALUE;

    // 0: 빈칸, 1: 집, 2: 피자집
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        pizza = new ArrayList<>();

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=N; j++){
                int cur = Integer.parseInt(st.nextToken());

                if (cur == 1) house.add(new Point(j, i));
                else if(cur == 2) pizza.add(new Point(j, i));
            }
        }

        savePizza = new ArrayList<>();
        dfs(0, 0);

        System.out.println(minDis);
    }

    // 살릴 피자집 조합
    static void dfs(int depth, int start) {
        // 조합 완성
        if (depth == M) {
            minDis = Math.min(minDis, calc());
            return;
        }

        for (int i=start; i<pizza.size(); i++){
            savePizza.add(pizza.get(i));
            dfs(depth+1, i+1);
            savePizza.remove(savePizza.size()-1);
        }
    }

    // 집과 피자집의 피자배달거리 계산
    static int calc(){
        int totalD = 0;

        for (Point h: house){
            int d = Integer.MAX_VALUE;

            for (Point p: savePizza){
                d = Math.min(d, Math.abs(h.x-p.x) + Math.abs(h.y-p.y));
            }

            totalD += d;
        }

        return totalD;
    }
}
