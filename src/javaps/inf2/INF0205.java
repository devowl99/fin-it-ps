package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0205 {

    static int solution(int N) {

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i=2; i*i<=N; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j<=N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean b: isPrime) {
            if (b) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}
