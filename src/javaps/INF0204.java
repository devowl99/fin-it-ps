package javaps;

import java.io.*;
import java.util.*;

public class INF0204 {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        nums[0] = nums[1] = 1;
        for (int i=2; i<N; i++){
            nums[i] = nums[i-2]+nums[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int x: nums) sb.append(x).append(' ');

        System.out.println(sb);
    }
}
