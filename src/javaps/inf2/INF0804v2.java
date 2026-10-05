package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0804v2 {

    static int N, M;
    static int[] perm;

    static void perm(int depth) {
        if (depth==M) {
            for (int x: perm) {
                System.out.print(x+" ");
            }
            System.out.println();

            return;
        }

        for (int i=1; i<=N; i++) {
            perm[depth] = i;
            perm(depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        perm = new int[M];
        perm(0);
    }
}