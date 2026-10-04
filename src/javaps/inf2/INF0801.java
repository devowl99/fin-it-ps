package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0801 {

    static int n;
    static int[] nums;

    static int[] sset1;
    static int[] sset2;
    static String answer;


    static String solution(int N, int[] arr) {
        sset1 = new int[N];
        sset2 = new int[N];

        n = N;
        nums = arr;

        answer = "NO";
        subset(0);

        return answer;
    }

    static void subset(int i) {
        if (answer.equals("YES")) return;

        if (i==n) {
            int ssum1 = 0;
            int ssum2 = 0;
            for (int j=0; j<n; j++) {
                ssum1 += sset1[j];
                ssum2 += sset2[j];
            }

            if (ssum1 == ssum2) answer = "YES";
            return;
        }

        sset1[i]=nums[i];
        sset2[i]=0;
        subset(i+1);

        sset1[i]=0;
        sset2[i]=nums[i];
        subset(i+1);
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
