package javaps;

import java.io.*;

public class INF0701 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        recursive(N);
    }

    static void recursive(int i){
        if (i==0) return;

        recursive(i-1);
        System.out.print(i+" ");
    }
}
