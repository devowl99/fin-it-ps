package javaps.inf2;

import java.io.*;

public class INF0704 {

    static int[] fibo;

    static int solution(int N) {
        if (fibo[N] != 0) return fibo[N];

        return fibo[N] = solution(N-1) + solution(N-2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        fibo = new int[N];
        fibo[0] = fibo[1] = 1;

        solution(N-1);
        for (int i: fibo) {
            System.out.print(i+" ");
        }
    }
}
