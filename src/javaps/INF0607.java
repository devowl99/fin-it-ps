package javaps;

import java.io.*;
import java.util.*;

public class INF0607 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Point[] points;

    static class Point {
        int x, y;

        Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        points = new Point[N];

        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[n] = new Point(x, y);
        }


    }
}
