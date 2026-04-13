package javaps;

import java.io.*;
import java.util.*;

public class INF0802 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int C, N;
    static int[] dogs;
    static int maxW = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dogs = new int[N];
        for (int n=0; n<N; n++){
            dogs[n] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
        System.out.println(maxW);
    }

    static void dfs(int i, int sum){
        if (sum > C) return; // 가지치기

        if (i == N) {
            maxW = Math.max(maxW, sum);
            return;
        }

        // 태우는 경우
        dfs(i+1, sum+dogs[i]);

        // 안 태우는 경우
        dfs(i+1, sum);
    }
}
