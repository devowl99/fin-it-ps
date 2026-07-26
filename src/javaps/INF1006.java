package javaps;

import java.io.*;
import java.util.*;

// 개수가 무한 : 앞에서부터 뒤로 dp
// 개수가 유한 : 뒤에서부터 앞으로 dp

public class INF1006 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static class Quiz {
        int score;
        int time;

        Quiz (int score, int time){
            this.score = score;
            this.time = time;
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

        dp = new int[M+1]; // 누적 점수
        dp[0] = 0;

        int maxS = 0;
        for (Quiz q: qArr){
            for (int i=M; i>=q.time; i--){
                dp[i] = Math.max(dp[i], dp[i-q.time] + q.score);
                maxS = Math.max(maxS, dp[i]);
            }
        }

        System.out.println(maxS);
    }
}
