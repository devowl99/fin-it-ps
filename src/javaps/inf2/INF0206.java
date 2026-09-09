package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0206 {

    static boolean[] isPrime;

    static String solution(int N, int[] nums, int maxNum) {

        era(maxNum);

        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int target;
        for (int n=0; n<N; n++) {
            target = Integer.parseInt(sb.append(nums[n]).reverse().toString());
            if (isPrime[target]) answer.append(target).append(' ');
            sb.setLength(0);
        }

        return answer.toString().trim();
    }

    static void era(int maxNum) {

        isPrime = new boolean[maxNum+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i=2; i*i<=maxNum; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j<=maxNum; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int n=0; n<N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, nums, 100000));
    }
}
