package javaps;

import java.io.*;
import java.util.*;

public class INF0806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int[] perm;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm = new int[M];
        dfs(0);

    }

    static void dfs(int depth){
        if (depth == M){
            for (int x: perm) System.out.print(x+" ");
            System.out.println();
            return;
        }

        for (int i=0; i<N; i++){
            if (visited[i]) continue;

            visited[i] = true;
            perm[depth] = arr[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }

}
