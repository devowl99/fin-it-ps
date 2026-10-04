package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0803 {

    static class Quiz {
        int score, time;

        Quiz(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    static int N, M;
    static Quiz[] quizs;
    static int maxScore;

    static void solution() {
        maxScore = Integer.MIN_VALUE;

        dfs(0, 0, 0);
    }

    static void dfs(int i, int totalScore, int totalTime) {
        if (totalTime>M) return;

        if (i==N) {
            maxScore = Math.max(maxScore, totalScore);
            return;
        }

        dfs(i+1, totalScore+quizs[i].score, totalTime+quizs[i].time);
        dfs(i+1, totalScore, totalTime);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        quizs = new Quiz[N];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());

            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            quizs[n] = new Quiz(score, time);
        }

        solution();
        System.out.println(maxScore);
    }
}
