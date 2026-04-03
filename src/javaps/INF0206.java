package javaps;

import java.io.*;
import java.util.*;

public class INF0206 {
    static int N;
    static int[] nums;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num;
        int result;
        for (int i=0; i<N; i++){
            num = Integer.parseInt(st.nextToken());
            result = 0;
            while(num != 0){
                int tmp = num%10;
                result = result*10 + tmp;
                num = num/10;
            }

            nums[i] = result;
        }

        sieve();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            if (isPrime[nums[i]]) sb.append(nums[i]).append(' ');
        }

        System.out.println(sb);
    }

    static void sieve(){
        int MAX = 100000;
        isPrime = new boolean[MAX+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i=2; i*i<=MAX; i++){
            if (isPrime[i]){
                for (int j=i*i; j<=MAX; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
