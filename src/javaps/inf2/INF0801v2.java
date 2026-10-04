package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0801v2 {

    static int n;
    static int[] nums;

    static String answer;


    static String solution(int N, int[] arr) {

        n = N;
        nums = arr;

        answer = "NO";
        subset(0, 0, 0);

        return answer;
    }

    static void subset(int i, int sum1, int sum2) {
        if (answer.equals("YES")) return;

        if (i==n) {
            if (sum1==sum2) answer="YES";
            return;
        }

        subset(i+1, sum1+nums[i], sum2);
        subset(i+1, sum1, sum2+nums[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }
}
