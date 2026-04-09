package javaps;

import java.io.*;

public class INF0704v3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int N;
    static int[] fibo;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        fibo = new int[N+1];
        recursive(N);

        for (int i=1; i<N+1; i++){
            System.out.print(fibo[i] + " ");
        }
    }

    static int recursive(int i){
        if (i==1) return fibo[i] = 1;
        else if (i==2) return fibo[i] = 1;

        if (fibo[i] != 0) return fibo[i];
        else return fibo[i] = recursive(i-2) + recursive(i-1);
    }
}
