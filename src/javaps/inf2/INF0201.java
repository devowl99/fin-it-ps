package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0201 {

    static String solution(int N, int[] nums) {

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append(' ');

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) sb.append(nums[i]).append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n=0; n<N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, nums));
    }
}
