package javaps;

import java.io.*;
import java.util.*;

public class INF1004v3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static class Brick implements Comparable<Brick> {
        int s;
        int h;
        int w;

        Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return Integer.compare(o.w, this.w); // 무게 무거운 순 정렬
        }
    }

    static Brick[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new Brick[N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[i] = new Brick(s, h, w);
        }

        Arrays.sort(arr);
        dp = new int[N]; // 각 Brick 배열 인덱스의 누적 최대 높이

        int maxH = 0;
        // 밑면이 넓고, 무게가 무거운 벽돌 위에 쌓을 수 있음
        for (int i=0; i<N; i++){
            dp[i] = arr[i].h;

            for (int j=0; j<i; j++){
                if (arr[i].s < arr[j].s) { // 현재 넓이보다 더 넓음
                    dp[i] = Math.max(dp[i], dp[j] + arr[i].h);
                }
            }

            maxH = Math.max(maxH, dp[i]);
        }

        System.out.println(maxH);
    }
}
