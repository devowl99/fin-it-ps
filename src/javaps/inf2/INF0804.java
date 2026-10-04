package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0804 {

    static int N, M;
    static int[] arr;
    // static boolean[] visited;

    static int[] perm;

    static void perm(int depth) {
        if (depth==M) {
            for (int x: perm) {
                System.out.print(x+" ");
            }
            System.out.println();

            return;
        }

        for (int i=0; i<N; i++) {
            // if (visited[i]) continue;

            // visited[i] = true;
            perm[depth] = arr[i];
            perm(depth+1);
            // visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int n=0; n<N; n++){
            arr[n] = n+1;
        }
        // visited = new boolean[N];

        perm = new int[M];
        perm(0);
    }
}
