package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0204 {

    static StringBuilder solution(int N) {

        int[] fib = new int[N];
        fib[0] = fib[1] = 1;
        StringBuilder sb = new StringBuilder("1").append(' ').append('1').append(' ');
        for (int i=2; i<N; i++) {
            fib[i] = fib[i-2] + fib[i-1];
            sb.append(fib[i]).append(' ');
        }

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}
