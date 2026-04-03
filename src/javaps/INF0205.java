package javaps;

import java.io.*;
import java.util.*;

public class INF0205 {
    static int N;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=isPrime[1]=false;
        for (int i=2; i*i<=N; i++){
            for (int j=i*i; j<=N; j+=i) isPrime[j] = false;
        }

        int count = 0;
        for (int i=0; i<isPrime.length; i++){
            if (isPrime[i]) count++;
        }

        System.out.println(count);
    }
}
