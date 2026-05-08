package javaps;

import java.io.*;
import java.util.*;

public class INF1004 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Brick[] bArr;
    static int[] dp; // 누적 높이

    static class Brick implements Comparable<Brick>{
        int s;
        int h;
        int w;

        Brick (int s, int h, int w){
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o){
            return Integer.compare(o.s, this.s); // 밑변 넓은 순
        }
    }

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

        Arrays.sort(bArr); // 넓이 넓은 순 정렬

        dp = new int[N];
        dp[0] = bArr[0].h;
        int answer = 0;
        for (int i=1; i<N; i++){
            int maxH = 0;

            for (int j=0; j<i; j++){
                if (bArr[j].w > bArr[i].w && maxH < dp[j]) {
                    maxH = dp[j];
                }
            }

            dp[i] = maxH + bArr[i].h;

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
