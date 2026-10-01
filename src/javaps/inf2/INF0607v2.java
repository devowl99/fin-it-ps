package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0607v2 {

    static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x != o.x) {
                return Integer.compare(o.x, this.x);
            }
            else return Integer.compare(o.y, this.y);
        }
    }

    static String solution(List<Point> points) {
        Collections.sort(points, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Point p: points) {
            sb.append(p.x).append(' ').append(p.y).append('\n');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Point> points = new ArrayList<>();
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(solution(points));
    }
}