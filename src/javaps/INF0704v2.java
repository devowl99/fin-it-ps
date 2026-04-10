package javaps;

import java.io.*;

public class INF0704v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int N;
    static int[] fibo;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        fibo = new int[N+1];
        fibo[1] = fibo[2] = 1;
        recursive(3);

        for (int i=1; i<N+1; i++){
            System.out.print(fibo[i] + " ");
        }
    }

    static void recursive(int i){
        if (i > N) return;

        fibo[i] = fibo[i-2] + fibo[i-1];
        recursive(i+1);
    }
}
