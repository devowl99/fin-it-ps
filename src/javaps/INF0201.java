package javaps;

import java.io.*;
import java.util.*;

public class INF0201 {
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append(" ");
        for (int i=1; i<n; i++){
            if (nums[i-1] < nums[i]) sb.append(nums[i]).append(" ");
        }

        System.out.println(sb);
    }
}
