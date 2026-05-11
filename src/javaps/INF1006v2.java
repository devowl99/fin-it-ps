package javaps;

import java.io.*;
import java.util.*;

public class INF1006v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static class Quiz {
        int s;
        int t;

        Quiz (int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    static Quiz[] qArr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        qArr = new Quiz[N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            qArr[i] = new Quiz(s, t);
        }

        dp = new int[M+1]; // 인덱스 시간 별 최대 점수 기록

        for (Quiz q: qArr) {
            for (int i=M; i>=q.t; i--){
                dp[i] = Math.max(dp[i], dp[i-q.t]+q.s);
            }
        }

        System.out.println(dp[M]);
    }
}
