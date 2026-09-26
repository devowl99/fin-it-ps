package javaps.practice;

import java.io.*;
import java.util.*;

public class Perm {

    static int N;
    static int R;
    static int[] nums;

    static int[] perm;
    static boolean[] visited;

    static void solution(int n, int r, int[] arr) {
        N=n;
        R=r;
        nums = arr;

        perm = new int[R];
        visited = new boolean[N];

        perm(0);
    }

    static void perm(int depth) {
        if (depth == R) {
            for (int x: perm) {
                System.out.print(x+" ");
            }
            System.out.println();

            return;
        }

        for (int i=0; i<N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            perm[depth] = nums[i];
            perm(depth+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, r, arr);
    }
}
