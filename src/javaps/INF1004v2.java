package javaps;

import java.io.*;
import java.util.*;

public class INF1004v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static class Brick implements Comparable<Brick>{
        int s, h, w;

        Brick(int s, int h, int w){
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return Integer.compare(this.w, o.w); // 무게 가벼운 순 정렬
        }
    }

    static Brick[] bArr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        bArr = new Brick[N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bArr[i] = new Brick(size, height, weight);
        }

        Arrays.sort(bArr); // 무게 가벼운 순으로 정렬

        // 밑변 넓이가 좁은지만 비교하면 됨
        dp = new int[N];
        dp[0] = bArr[0].h;
        int maxH = 0;
        for (int i=0; i<N; i++){
            dp[i] = bArr[i].h;

            for (int j=0; j<i; j++){
                if (bArr[i].s > bArr[j].s) {
                    dp[i] = Math.max(dp[i], dp[j] + bArr[i].h);
                }
            }

            maxH = Math.max(maxH, dp[i]);
        }

        System.out.println(maxH);
    }
}
