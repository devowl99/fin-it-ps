package javaps.practice;

import java.io.*;
import java.util.*;

public class Subset {

    static int N;
    static int[] nums;

    static List<Integer> subset;

    static void solution(int n, int[] arr) {
        N = n;
        nums = arr;

        subset = new ArrayList<>();
        subset(0);
    }

    static void subset(int i) {
        if (i == N) {
            if (subset.isEmpty()) System.out.print("{}");

            for (int x: subset) {
                System.out.print(x+" ");
            }
            System.out.println();

            return;
        }

        subset.add(nums[i]);
        subset(i+1);

        subset.remove(subset.size()-1);
        subset(i+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, arr);
    }
}