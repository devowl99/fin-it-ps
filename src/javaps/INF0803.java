package javaps;

import java.io.*;
import java.util.*;

public class INF0803 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    static int[] score;
    static int[] time;
    static int maxScore = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        score = new int[N];
        time = new int[N];
        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            score[n] = Integer.parseInt(st.nextToken());
            time[n] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(maxScore);
    }

    static void dfs(int i, int totalScore, int totalTime){
        if (totalTime > M) return;
        if (i == N){
            maxScore = Math.max(maxScore, totalScore);
            return;
        }

        dfs(i+1, totalScore+score[i], totalTime+time[i]);
        dfs(i+1, totalScore, totalTime);
    }
}
