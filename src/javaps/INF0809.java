package javaps;

import java.io.*;
import java.util.*;

public class INF0809 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] comb;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 구슬 1~N
        M = Integer.parseInt(st.nextToken()); // M개 뽑기

        comb = new int[M];

        dfs(0, 1);

    }

    static void dfs(int depth, int start){
        if (depth == M){
            for (int x: comb) System.out.print(x+" ");
            System.out.println();
            return;
        }

        for (int i=start; i<=N; i++){
            comb[depth] = i;
            dfs(depth+1, i+1);
        }
    }
}
