package javaps.practice;

import java.io.*;
import java.util.*;

public class Comb {

    static int N;
    static int R;
    static int[] nums;

    static int[] comb;

    static void solution(int n, int r, int[] arr) {
        N = n;
        R = r;
        nums = arr;

        comb = new int[R];
        comb(0, 0);
    }

    static void comb(int depth, int start) {
        if (depth == R) {
            for (int x: comb) {
                System.out.print(x+" ");
            }
            System.out.println();

            return;
        }

        for (int i=start; i<nums.length; i++) {
            comb[depth] = nums[i];
            comb(depth+1, i+1);
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

