package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0607_2 {

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }

            return Integer.compare(this.x, o.x);
        }
    }

    static int N;
    static Point[] pArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pArr = new Point[N];
        StringTokenizer st;
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pArr[n] = new Point(x, y);
        }

        Arrays.sort(pArr);

        StringBuilder sb = new StringBuilder();
        for (Point p: pArr) {
            sb.append(p.x).append(' ').append(p.y).append('\n');
        }

        System.out.println(sb);
    }
}
